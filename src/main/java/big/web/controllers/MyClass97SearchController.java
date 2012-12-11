package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass133Service;
import big.domain.MyClass133;
import big.repositories.criteria.MyClass97Criteria;
import org.springframework.ui.Model;
import java.util.List;
import big.services.MyClass97Service;
import big.domain.MyClass97;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass97.class)
public class MyClass97SearchController
{

	
	@Autowired
	private MyClass133Service myClass133Service;
	
	@Autowired
	private MyClass97Service myClass97Service;
    

	@ModelAttribute(value = "myclass133s")
	public List<MyClass133> getMyClass133s () 
	{
		return this.myClass133Service.findAll();	
	}

	@RequestMapping(value = "/myclass97/list", method = RequestMethod.GET)
	public List<MyClass97> list (Model model) 
	{
		MyClass97Criteria myClass97Criteria = new MyClass97Criteria();
		model.addAttribute(myClass97Criteria);
		return this.myClass97Service.findAll();	
	}

	@RequestMapping(value = "/myclass97/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass97> search (@ModelAttribute MyClass97Criteria criteria) 
	{
		return this.myClass97Service.findByCriteria(criteria);	
	}


}
