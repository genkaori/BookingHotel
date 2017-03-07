package vn.framgia.service;

import java.io.Serializable;

import vn.framgia.dao.IUserDAO;

public interface IBaseService extends Serializable {
	IUserDAO getUserDAO();
}
