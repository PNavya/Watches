package com.niit.ShoppingCart.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.model.Category;

@Controller

public class CategoryController {

	private static Logger Log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String listCategories(Model model) {

		Log.debug("starting of the method listCategories");
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		Log.debug("End of the method listCategories");
		return "category";
	}
	@ModelAttribute
	public Category returncate()
	{
		return new Category();
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute("category") Category cat) {
		Log.debug("starting of the method addCategory");

		ModelAndView mv = new ModelAndView("category");
        System.out.println("Test Case 2");
		//if(categoryDAO.get(category.getId()) == null)
		{
			System.out.println("Test case 3");
			categoryDAO.save(cat);
		} 
		//else 
		{
			mv.addObject("error message,if exists with this id" + category.getCatid());
		}
		Log.debug("ending of the method addcategories");
		return mv;

	}
	@RequestMapping("category/delete/{catid}")
	public ModelAndView deleteCategory(@PathVariable("catid") String catid,Category cat) throws Exception {
		category = categoryDAO.get(catid);
		ModelAndView mv = new ModelAndView("viewcategory");
		System.out.println("delete");
		//if (category == null) {
			//mv.addObject("errorMessage", "could not delete the category");
		//} else {
			categoryDAO.delete(cat);
		//}
		return mv;
	}

	@RequestMapping(value = "/update/{catid}")
	public ModelAndView updateCategory(@PathVariable("catid") String catid) {
		ModelAndView mv = new ModelAndView("updateCategory");
		System.out.println("update");
		category=categoryDAO.get(catid);
		System.out.println("getCatid()");
		mv.addObject("cat", category);
		mv.addObject("categoryList", this.categoryDAO.list());
		
		return mv;
	}
	@RequestMapping(value = "*/edit/{catid}", method = RequestMethod.POST)
	public ModelAndView edit(@ModelAttribute("category") Category cat,BindingResult result,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("viewcategory");
		System.out.println("hai");
		categoryDAO.update(cat);
		mv.addObject("categoryList", categoryDAO.list());
		
		return mv;
	}
	

}
