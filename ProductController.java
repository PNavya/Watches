package com.niit.ShoppingCart.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.dao.CategoryDAO;
import com.niit.ShoppingCart.dao.ProductDAO;
import com.niit.ShoppingCart.model.Category;
import com.niit.ShoppingCart.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private Product product;

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	
	private Category category;
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String listSuppliers(Model model) {

		model.addAttribute("product", new Product());
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());

		return "addProduct";
	}
	@RequestMapping(value="/addprod", method = RequestMethod.POST)
	public String Productregister(@Valid @ModelAttribute("product") Product prod,Model model, BindingResult result,
						HttpServletRequest request) throws IOException {
					//ModelAndView mv = new ModelAndView("bootstrap");
			
					@SuppressWarnings("unused")
					String filename;
					@SuppressWarnings("unused")
					byte[] bytes;
					System.out.println(prod.getName());
			
				System.out.println("image uploaded");
			
					System.out.println("myproduct controller called");
					MultipartFile image = prod.getImage();
					Path path;
					path = Paths.get(
							"E:/maven/ShoppingCartFront/src/main/webapp/resources/images/" + prod.getName() + ".jpg");
			
					System.out.println("Path = " + path);
					System.out.println("File name = " + prod.getImage().getOriginalFilename());
					if (image != null && !image.isEmpty()) {
						try {
							image.transferTo(new File(path.toString()));
							System.out.println("Image Saved in:" + path.toString());
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("Image not saved");
						}
					}
					Category category = categoryDAO.getId(prod.getCategory().getCatid());
					//categoryDAO.save(category);
					prod.setCategory(category);					
					prod.setCatid(category.getCatid());
					productDAO.save(prod);
					
					return "product";
				}
	
	@RequestMapping("product/delete/{prodid}")
	public String removeSupplier(@ModelAttribute("product") Product prod) throws Exception {
	
		//supplier = supplierDAO.get(supId);
		
		ModelAndView mv = new ModelAndView("addProduct");
		
		if(product==null)
			
		{
			mv.addObject("error messaege","could not delete the supplier");
		}
		else
		{
			productDAO.delete(prod);
		}
		return "addProduct";
	}
	@RequestMapping("product/update/{prodid}")
	public String editSupplier(@PathVariable("prodid") String prodid, Model model){
		
		System.out.println("edit product");
		model.addAttribute("product",this.productDAO.get(prodid));
		model.addAttribute("listProduct",this.productDAO.list());		
	
		return "addProduct";
	
	
	}

}
