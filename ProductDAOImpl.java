package com.niit.ShoppingCart.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.Product;
@EnableTransactionManagement

@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO{
	
	//private static final Logger log=LoggerFactory.getLogger(ProductDAOImpl.class);
	//private static final Logger log=LoggerFactory.getLogger("com.niit.ShoppingCart.dao.ProductDAOImpl.class");

	@Autowired
	private SessionFactory sessionfactory;
	public ProductDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	 @Transactional
		public boolean save(Product product) {
			try {
				//log.debug("Starting of the method save");
				sessionfactory.getCurrentSession().save(product);
			
				//log.debug("Ending of the method save");

				return true;
			} catch (Exception e) {
				//log.error("Exception occured in save method" +e.getMessage());
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	   @Transactional
		public boolean update(Product product) {
			try {
				sessionfactory.getCurrentSession().update(product);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	@Transactional
		public boolean delete(Product product) {
			try {
				sessionfactory.getCurrentSession().delete(product);
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	@Transactional
		public Product get(String prodid) {

			String hql = "from Product where prodid=" + "'" + prodid + "'";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			List<Product> list = query.list();
			if (list == null)

				return null;
			else {
				return list.get(0);
			}
		}
	@Transactional
		public List<Product> list() {
		
		    
			String hql = "from Product";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			return query.list();

		}
	
	
	
	
}
