package com.vn;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import com.vn.entities.*;
import com.vn.utils.HibernateUtil;

public class UserMain {
	
	static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public static void main(String[] args) {
		UserMain main = new UserMain();
		List<User> users = main.getAllUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	//get all data
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		//1. create variable
		List<User> result = new ArrayList<User>();
		Session session = null;
		Transaction transaction = null;
		try {
			//2. Create value for variable
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			//3. Create Query
			//session.createSQLQuery(queryString) => SQL
			
			//List<Category> categories = q.list();
			result = session.createQuery("FROM User").list();
			//4. Execute Query => List
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			/*
			 * if(transaction != null) { transaction.rollback(); }
			 */
		}
		return result;
	}

	//add
	
	
	//update
	
	
	//xoa
}
