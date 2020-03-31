package com.vn;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.vn.entities.Category;
import com.vn.entities.Product;
import com.vn.utils.HibernateUtil;

public class CategoryService {
	
	public static void main(String[] args) {
		CategoryService productService = new CategoryService();
		Category c = productService.getById(1);
		//System.out.println(p);
	}
	
	static SessionFactory factory = HibernateUtil.getSessionFactory();
	
	//add
	//update
	//delete/
	//getAll
	//get by id
	public Category getById(int id) {
		//1. Taoj session , transaction
		Session session =  null; 
		org.hibernate.Transaction tx =  null; 
		Category c = new Category();
		try {
			session = factory.getCurrentSession();
			tx = session.beginTransaction();
			
			//2. get by id
			
			/*SQLQuery q = session.createSQLQuery("SELECT * FROM category where id= " + String.valueOf(id));
			List<Object[]> rows = q.list();
			for(Object[] row : rows){
				Category emp = new Category();
				emp.setId((Integer) row[0]);
				emp.setName(row[1].toString());
				emp.setDescription(row[2].toString());
				//emp.setImage(row[3].toString());
				System.out.println(emp);
			}*/
			
			String hql = "SELECT c FROM Category c where c.id =:idCA";
			org.hibernate.Query query =  session.createQuery(hql);	
			query.setParameter("idCA", id);
			c = (Category) query.uniqueResult();
			
			//3. close session
			//tx.commit();
			session.close();
			return c;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
