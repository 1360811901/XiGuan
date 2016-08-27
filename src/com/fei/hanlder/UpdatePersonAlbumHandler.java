package com.fei.hanlder;

import java.util.Map;

import com.fei.Entity.UserAlbum;
import com.fei.daoImpl.UserAlbumDaoImp;
import com.fei.design2.Params;
import com.fei.feithrows.FinalStringError;
import com.fei.fileUpload.FileUp;
import com.fei.fileUpload.FileUpload2;

import net.sf.json.JSONObject;

public class UpdatePersonAlbumHandler extends Handler {

	private FileUp fileUp;

	public void setFileUp(FileUp fileUp) {
		this.fileUp = fileUp;
	}

	@Override
	public String processHandler(Params p) {
		UserAlbum[] album = createUserAlbum();

		UserAlbumDaoImp albumDao = new UserAlbumDaoImp();
		try {
			for (int i = 0; i < album.length; i++) {
				if (album[i] != null)
					albumDao.save(album[i]);
			}
			return "{\"code\":200,\"causeBy\":\"save album is ok >>>>\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return FinalStringError.SYSTEM_ERROR;
	}

	private UserAlbum[] createUserAlbum() {
		FileUpload2 fileup2 = (FileUpload2) this.fileUp;
		Map<String, String> formField = fileup2.getFormField();
		JSONObject[] ja = fileup2.getFileMsg();

		String userId = formField.get("userId");
		UserAlbum[] album = new UserAlbum[6];
		for (int i = 0; i < ja.length; i++) {
			UserAlbum useral = new UserAlbum();
			useral.setUserInfoId(userId);
			JSONObject a = ja[i];
			if (a != null) {
				useral.setFileName(a.getString("fileName"));
				useral.setPhotetype(a.getString("photeType"));
				useral.setSort(a.getString("sort"));
				useral.setUrl(a.getString("url"));
				useral.setSize(a.getString("size"));
				album[i] = useral;
			}
		}
		return album;
	}

}
