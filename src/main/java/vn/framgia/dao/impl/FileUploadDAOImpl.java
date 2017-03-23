package vn.framgia.dao.impl;


import org.hibernate.Session;

import vn.framgia.bean.FileUploadBean;
import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IFileUploadDAO;
import vn.framgia.model.FileUpload;
import vn.framgia.model.User;

@SuppressWarnings("serial")
public class FileUploadDAOImpl extends GenericDAO<FileUpload, Integer> implements IFileUploadDAO {
	
	public FileUploadDAOImpl() {
		super.setPersistentClass(FileUpload.class);
	}

	@Override
	public void save(FileUploadBean fileUploadBean) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(fileUploadBean);
	}
}