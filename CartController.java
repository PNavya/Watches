package com.niit.ShoppingCart.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.dao.CartDAO;
import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.dao.UserDetailsDAO;
import com.niit.ShoppingCart.model.Cart;
import com.niit.ShoppingCart.model.Product;



@Controller
public class CartController {
	@Autowired
	CartDAO cartDAO;
	@Autowired
	Cart cart;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	Product product;
	@Autowired
	UserDetailsDAO userDetailsDAO;

	@ModelAttribute
	public Cart returnObject() {
		return new Cart();
	}

	@RequestMapping("/viewproducts")
	public ModelAndView productViewDetails(@RequestParam("prodid") String prodid,Model model) {
		System.out.println("I am in productViewDetails");
		System.out.println("ID:" + prodid);
		//int i = Integer.parseInt(prodid);
		model.addAttribute("productList", this.productDAO.list());
		Product product = productDAO.get(prodid);
		return new ModelAndView("viewproducts", "product", product);
	}
	@RequestMapping(value = "/buy{id}&{pid}")
	public ModelAndView buyproductPage(@Valid @PathVariable("id") String id, @PathVariable("pid") String pid,@RequestParam("quantity") String quantity,
			HttpSession session) throws Exception {
		int k = Integer.parseInt(quantity);
		ModelAndView mv = new ModelAndView("cart");
		cart.setQuantity(k);
		cart.setUser_Id(id);
		cart.setProd_Id(pid);
		cart.setCartuser(userDetailsDAO.get(id));
		product = productDAO.get(pid);
		cart.setCartproduct(product);
		System.out.println("1");
		cart.setPrice(cart.getQuantity()*product.getPrice());
		System.out.println("2");
		cartDAO.save(cart);
		System.out.println("3");
		mv.addObject("mycartList", cartDAO.mycartproducts(id));
		System.out.println("4");
		session.setAttribute("cartvalue", cartDAO.totalproducts(id));
		System.out.println("5");

		return mv;
	}

	@RequestMapping(value = "/viewmycart{id}")
	public ModelAndView viewmycart(@PathVariable("id") String id) throws Exception {
		ModelAndView mv = new ModelAndView("cart");
		mv.addObject("mycartList", cartDAO.mycartproducts(id));
		System.out.println(cartDAO.totalprice(id));
		return mv;
	}

	@RequestMapping(value = "/cartitemdelete{id}&{pid}")
	public ModelAndView deleteCategory(@PathVariable("id") String id, @PathVariable("pid") String pid,
			HttpSession session) throws Exception {
		System.out.println(id);
		System.out.println(pid);
		cartDAO.delete(id, pid);
		ModelAndView mv = new ModelAndView("cart");
		mv.addObject("mycartList", cartDAO.mycartproducts(id));
		session.setAttribute("cartvalue", cartDAO.totalproducts(id));
		System.out.println(cartDAO.totalprice(id));
		return mv;
	}

}