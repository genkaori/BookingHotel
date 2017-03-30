package vn.framgia.service;

import java.io.Serializable;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface IFileUploadService extends Serializable {
	public boolean saveFile(CommonsMultipartFile[] file);

}
