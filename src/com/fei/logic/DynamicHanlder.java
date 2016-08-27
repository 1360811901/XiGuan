package com.fei.logic;

import com.fei.daoImpl.DynamicPhotoDAOImp;
import com.fei.daoImpl.UserDynamicsDAOImp;

public class DynamicHanlder extends Hanlder {
	/**
	 * 保存动态的图片信息到数据库中
	 */
	@Override
	public void saveFileEntity() {
		for(int i = 0; i<fileInfo.length;i++){
			DynamicPhotoDAOImp dd = new DynamicPhotoDAOImp();
			try {
				dd.save(fileInfo[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 保存动态的字段信息到数据库中
	 */
	@Override
	public void saveFormEntity() {
		UserDynamicsDAOImp ud = new UserDynamicsDAOImp();
		try {
			ud.save(formField, dnId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
