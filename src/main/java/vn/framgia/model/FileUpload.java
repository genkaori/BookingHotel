package vn.framgia.model;

import java.io.Serializable;

public class FileUpload implements Serializable{
	private int id;
	private String fileName;
	private byte[] fileData;

	public FileUpload() {
		super();
	}
	
	public FileUpload(int id, String fileName, byte[] fileData){
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileData = fileData;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

}
