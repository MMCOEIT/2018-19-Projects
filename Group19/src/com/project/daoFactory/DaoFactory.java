package com.project.daoFactory;

import com.project.dao.AdminDao;
import com.project.dao.AdminDaoImpl;
import com.project.dao.BookDao;
import com.project.dao.BookDaoImpl;
import com.project.dao.UserDao;
import com.project.dao.UserDaoImpl;

public class DaoFactory  {

	public static UserDao getInstances()
	{
		return new  UserDaoImpl();
		
	}
	
	public static BookDao getInstancesBook()
	{
		return new BookDaoImpl();
	}
	
	public static AdminDao getInstanceAdmin()
	{
		return new AdminDaoImpl();
	}
	
}
