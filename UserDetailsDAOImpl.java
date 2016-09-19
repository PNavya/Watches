package com.niit.ShoppingCart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.UserDetails;
@EnableTransactionManagement

@Repository("userdetailsDAO")

public class UserDetailsDAOImpl implements UserDetailsDAO{
	
	@Autowired
	private SessionFactory sessionfactory;
	public UserDetailsDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	 @Transactional
		public boolean save(UserDetails userdetails) {
			try {
				
				sessionfactory.getCurrentSession().save(userdetails);
				
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	   @Transactional
		public boolean update(UserDetails userdetails) {
			try {
				sessionfactory.getCurrentSession().update(userdetails);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	@Transactional
		public boolean delete(UserDetails userdetails) {
			try {
				sessionfactory.getCurrentSession().delete(userdetails);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	@Transactional
		public UserDetails get(int id) {

			String hql = "from UserDetails where id=" + " ' " + id + "'";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			List<UserDetails> list = query.list();
			if (list == null)

				return null;
			else {
				return list.get(0);
			}
		}
	
	@Transactional
	public UserDetails isValidUser(String name,String password)
	{
		
		
		//select * from UserDetails where id='101' and password='niit'
		String hql="from UserDetails where name = '" +name+"' and password='"+password+"'";
		Query query=sessionfactory.getCurrentSession().createQuery(hql);
		
		List<UserDetails> list=query.list();
		
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
		
	}
	@Transactional
		public List<UserDetails> list() {
			String hql = "from UserDetails";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			return query.list();

		}

	
	
	
	
}
