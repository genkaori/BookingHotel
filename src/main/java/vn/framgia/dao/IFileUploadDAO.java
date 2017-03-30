package vn.framgia.dao;

import vn.framgia.bean.FileUploadBean;
import vn.framgia.model.FileUpload;

public interface IFileUploadDAO extends IGenericDAO<FileUpload, Integer>{
	public void save(FileUploadBean fileUploadBean);

}
