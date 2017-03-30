package vn.framgia.service.impl;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import vn.framgia.model.FileUpload;
import vn.framgia.service.IFileUploadService;

@SuppressWarnings("serial")
public class FileUploadServiceImpl extends BaseserviceImpl implements IFileUploadService {

	@Override
	public boolean saveFile(CommonsMultipartFile[] file) {
		if (file != null && file.length > 0) {
			for (CommonsMultipartFile alife : file) {
				FileUpload fileUpload = new FileUpload();
				fileUpload.setFileName(alife.getOriginalFilename());
				fileUpload.setFileData(alife.getBytes());
				fileUploadDAO.save(fileUpload);

			}
			return true;
		}
		return false;
	}

}
