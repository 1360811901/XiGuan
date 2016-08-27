package com.fei.hanlder;

import com.fei.daoImpl.UserAlbumDaoImp;
import com.fei.design2.Params;
import com.fei.design2.params.DeleteAlbumParams;
import com.fei.feithrows.FeiException;
import com.fei.feithrows.FinalStringError;

/**
 * 将照片的isDel 设为true
 * @author Administrator
 *
 */
public class DeleteAlbumHandler extends Handler {
	
	@Override
	public String processHandler(Params p) {
		DeleteAlbumParams params = (DeleteAlbumParams)p;
		UserAlbumDaoImp albumDao = new UserAlbumDaoImp();
		try{
			albumDao.delete(params.getFileId());
			return "{\"code\":200,\"causeBy\":\"delete a blum is ok >>>>\"}";
		}catch(FeiException e){
			return e.toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		return FinalStringError.SYSTEM_ERROR;
	}

}
