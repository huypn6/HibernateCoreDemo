package com.vn;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vn.entities.Product;
import com.vn.utils.HibernateUtil;

public class ProductService {
	
	public static void main(String[] args) {
		ProductService productService = new ProductService();
		Product p = productService.getById(1);
		//System.out.println(p);
	}
	
	static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	//add
	//update
	//delete/
	//getAll
	//get by id
	public Product getById(int id) {
		//1. Taoj session , transaction
		Session session =  null; 
		org.hibernate.Transaction tx =  null; 
		Product p = new Product();
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			
			//2. get by id
			SQLQuery q = session.createSQLQuery("SELECT * FROM product where id= " + String.valueOf(id));
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				Product emp = new Product();
				emp.setId((Integer) row[0]);
				emp.setName(row[1].toString());
				System.out.println(emp);
			}
			//3. close session
			//tx.commit();
			session.close();
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
