package com.fei.design2.params;

import com.fei.design2.Params;

public class DeleteAlbumParams extends Params {
	private String fileId;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Override
	public boolean matchPrivateParams() {
		// TODO Auto-generated method stub
		return true;
	}
}
