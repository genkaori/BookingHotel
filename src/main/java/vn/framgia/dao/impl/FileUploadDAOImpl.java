package vn.framgia.dao.impl;

import org.hibernate.Session;

import vn.framgia.bean.FileUploadBean;
import vn.framgia.dao.GenericDAO;
import vn.framgia.dao.IFileUploadDAO;
import vn.framgia.model.FileUpload;

public class FileUploadDAOImpl extends GenericDAO<FileUpload, Integer> implements IFileUploadDAO {

	@Override
	public void save(FileUploadBean fileUploadBean) {
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(fileUploadBean);
	}

}
