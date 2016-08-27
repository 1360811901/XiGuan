package com.fei.daoImpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.fei.Entity.UserDynamics;
import com.fei.dao.UserDynamicsDAO;
import com.fei.tools.FinalString;
import com.fei.tools.Utils;

public class UserDynamicsDAOImp implements UserDynamicsDAO {

	@Override
	public void save(Map<String,String> formFields,String dnId) throws Exception {
		try(Session session = Utils.getSession()){
			UserDynamics dy = new UserDynamics();
			dy.setUserName(formFields.get(FinalString.USERNAME));
			dy.setDnId(dnId);
			dy.setContent(formFields.get(FinalString.DYNAMICCONTENT));
			dy.setuTime("" + System.currentTimeMillis());
			dy.setLongitude(formFields.get(FinalString.LONGITUDE));
			dy.setLatitude(formFields.get(FinalString.LATITUDE));
			dy.setProvince(formFields.get(FinalString.PROVINCE));
			dy.setCity(formFields.get(FinalString.CITY));
			dy.setuType(formFields.get(FinalString.UTYPE));
			dy.setDestination(formFields.get(FinalString.DESTINATION));
			dy.setBeginTime(formFields.get(FinalString.BEGINTIME));
			dy.setOverTime(formFields.get(FinalString.OVERTIME));
			Transaction tx = session.beginTransaction();
			session.save(dy);
			tx.commit();
		}catch(Exception e){
			throw e;
		}
	}
	
	@Override
	public void clickOnLike(String dnid) throws Exception {
		try(Session session = Utils.getSession()){
			//获取相应的记录
			String sql = "from UserDynamics where dnId = '" + dnid + "'";
			List<UserDynamics> dys = session.createQuery(sql).list();
			if(dys.size() == 0)
				return;
			if(dys.size() == 1){
				UserDynamics dy = dys.get(0);
				int like = Integer.parseInt(dy.getClickOnLike());
				like ++;
				String sqll = "update UserDynamics set clickOnLike = '" + like + "' where dnId = '" + dnid + "'";
				Transaction ts = session.beginTransaction();
				session.createQuery(sqll).executeUpdate();
				ts.commit();
			}
		}catch(Exception e){
			throw e;
		}
	}

}
