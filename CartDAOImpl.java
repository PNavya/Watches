package com.niit.ShoppingCart.dao;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.Cart;



@Repository("cartDAO")
@Transactional

public class CartDAOImpl implements CartDAO {

	@Autowired
	ProductDAO productDAO;
	private static final Query SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public boolean save(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	//@Transactional
	public boolean delete(String id,String pid){
		try {
			Session s = sessionFactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			String hql = "delete from Cart where user_id="+"'"+id+"'"+" and prod_id="+"'"+pid+"'";
     		org.hibernate.Query query = s.createQuery(hql);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Cart getbyid(int id) {
		try {
			String hql = "from Cart where id=" + "'" + id + "'";
			Session s = sessionFactory.getCurrentSession();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> list = query.list();
			if (list == null)

				return null;
			else {
				return list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	//@Transactional
	public List<Cart> mycartproducts(String id) {
		try {
			String hql = "from Cart where user_id=" + "'" + id + "'";
			Session s = sessionFactory.getCurrentSession();
			Transaction tx=s.beginTransaction();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	//@Transactional
	public int totalproducts(String id) {
		try {
			String hql = "from Cart where user_id=" + "'" + id + "'";
			Session s = sessionFactory.getCurrentSession();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			int k = 0;
			for (Cart temp : all) {
				k = k + 1;
			}
			return k;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public int totalprice(String id){
	try{
		String hql = "from Cart where user_id=" + "'" + id + "'";
		Session s = sessionFactory.getCurrentSession();
		org.hibernate.Query query = s.createQuery(hql);
		List<Cart> all = query.list();
		int k=0;
		for (Cart temp : all) {
			k = k + temp.getPrice();
		}		
		return k;	
	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	}
	
	}
	//@Transactional
	public boolean orphanremoval(String id) {
		try {
			String hql = "delete from Cart where prod_id="+"'"+id+"'";
			Session s = sessionFactory.getCurrentSession();
			org.hibernate.Query query = s.createQuery(hql);
			query.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

	//@Transactional
	public List<Cart> list() {
		try {
			String hql = "from Cart";
			Session s = sessionFactory.getCurrentSession();
			org.hibernate.Query query = s.createQuery(hql);
			List<Cart> all = query.list();
			return all;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}