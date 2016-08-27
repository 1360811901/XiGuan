package com.fei.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fei.Entity.UserAlbum;
import com.fei.dao.UserAlbumDao;
import com.fei.feithrows.FeiException;
import com.fei.tools.Utils;

import net.sf.json.JSONObject;

public class UserAlbumDaoImp implements UserAlbumDao {

	@Override
	public void save(UserAlbum album) throws Exception {
		try(Session session = Utils.getSession()){
			Transaction tra = session.beginTransaction();
			session.save(album);
			tra.commit();
		}catch(Exception e){
			throw e;
		}
	}


	@Override
	public void delete(String userInfoId, String sort) throws Exception {
		try(Session session = Utils.getSession()){
			Transaction tra = session.beginTransaction();
			
			String sql = "update UserAlbum set isDel = 'YES' where userInfoId = '" + userInfoId + "' and sort = '" + sort +"'";
			int i = session.createQuery(sql).executeUpdate();
			System.out.println(i);
			if(i == 1){
				tra.commit();
			}else{
				throw new FeiException("photo is not correct",1101);
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public JSONObject get(String userInfoId) throws Exception {
		try(Session session = Utils.getSession()){
			String sql = "from UserAlbum where userInfoId = '" + userInfoId + "' and isDel = 'NO'";
			List<UserAlbum> albums = session.createQuery(sql).list();
			int a = albums.size();
			List<String> uris = new ArrayList<String>();
			for(int i=0;i<a;i++){
				String uri = albums.get(i).getUrl();
				uris.add(uri);
			}
			JSONObject json = new JSONObject();
			json.accumulate("count", a);
			json.accumulate("uri", uris);
			return json;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void delete(String fileId) throws Exception {
		try(Session session = Utils.getSession()){
			Transaction tra = session.beginTransaction();
			
			String sql = "update UserAlbum set isDel = 'YES' where fileName = '" + fileId +"'";
			int i = session.createQuery(sql).executeUpdate();
			System.out.println(i);
			if(i == 1){
				tra.commit();
			}else{
				throw new FeiException("photo is not correct",1101);
			}
		}catch(Exception e){
			throw e;
		}
	}

}
