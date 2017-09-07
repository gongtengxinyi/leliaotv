package com.dingjianlei.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class User {
	private String fileIndexDownload;
	private String fileIndexUpload;

	public String getFileIndexDownload() {
		return fileIndexDownload;
	}

	public void setFileIndexDownload(String fileIndexDownload) {
		this.fileIndexDownload = fileIndexDownload;
	}

	public String getFileIndexUpload() {
		return fileIndexUpload;
	}

	public void setFileIndexUpload(String fileIndexUpload) {
		this.fileIndexUpload = fileIndexUpload;
	}

}
