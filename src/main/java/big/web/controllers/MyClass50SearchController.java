package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass50Criteria;
import big.domain.MyClass50;
import org.springframework.ui.Model;
import big.services.MyClass139Service;
import java.util.List;
import big.domain.MyClass139;
import big.services.MyClass50Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass50.class)
public class MyClass50SearchController
{

	
	@Autowired
	private MyClass139Service myClass139Service;
	
	@Autowired
	private MyClass50Service myClass50Service;
    

	@ModelAttribute(value = "myclass139s")
	public List<MyClass139> getMyClass139s () 
	{
		return this.myClass139Service.findAll();	
	}

	@RequestMapping(value = "/myclass50/list", method = RequestMethod.GET)
	public List<MyClass50> list (Model model) 
	{
		MyClass50Criteria myClass50Criteria = new MyClass50Criteria();
		model.addAttribute(myClass50Criteria);
		return this.myClass50Service.findAll();	
	}

	@RequestMapping(value = "/myclass50/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass50> search (@ModelAttribute MyClass50Criteria criteria) 
	{
		return this.myClass50Service.findByCriteria(criteria);	
	}


}
