package com.niit.ShoppingCart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.dao.SupplierDAO;
import com.niit.ShoppingCart.model.Category;
import com.niit.ShoppingCart.model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierDAO supplierDAO;
	@Autowired
	
	private Supplier supplier;
	
	@RequestMapping(value = "/addSupplier", method = RequestMethod.GET)
	public String listSuppliers(Model model) {

		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList", this.supplierDAO.list());

		return "addSupplier";
	}
	@RequestMapping(value = "/supplier/add", method = RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier) {

		supplierDAO.save(supplier);
		// return "supplier";//see once its correct or not
		return "addSupplier";
	}
	@RequestMapping("supplier/delete/{supId}")
	public String removeSupplier(@ModelAttribute("supplier") Supplier sup) throws Exception {
	
		//supplier = supplierDAO.get(supId);
		
		ModelAndView mv = new ModelAndView("addSupplier");
		
		if(supplier==null)
			
		{
			mv.addObject("error messaege","could not delete the supplier");
		}
		else
		{
			supplierDAO.delete(sup);
		}
		return "addSupplier";
	}
	@RequestMapping("supplier/update/{supId}")
	public String editSupplier(@PathVariable("supId") String supId, ModelMap model){
		
		System.out.println("edit supplier");
		model.addAttribute("supplier",this.supplierDAO.get(supId));
		model.addAttribute("listSuppliers",this.supplierDAO.list());		
	
		return "addSupplier";
	
	
	}
}
