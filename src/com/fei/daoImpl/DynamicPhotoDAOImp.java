package com.fei.daoImpl;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fei.Entity.DynamicPhoto;
import com.fei.dao.DynamicPhotoDAO;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

public class DynamicPhotoDAOImp implements DynamicPhotoDAO{
	@Override
	public void save(Map<String,String> photoInfo) throws Exception {
		 try(Session session = Utils.getSession()){
			 Transaction ts = session.beginTransaction();
			 DynamicPhoto dp = new DynamicPhoto();
			 dp.setUrl(photoInfo.get(FinalString.URL));
			 dp.setDynamicId(photoInfo.get(FinalString.DYNAMICID));
			 dp.setFileName(photoInfo.get(FinalString.FILENAME));
			 dp.setSize(photoInfo.get(FinalString.SIZE));
			 session.save(dp);
			 ts.commit();
		 }catch(Exception e){
			 e.printStackTrace();
			 throw e;
		 }
	}
}
