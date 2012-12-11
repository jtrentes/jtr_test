package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass50Service;
import java.util.List;
import big.services.MyClass115Service;
import big.domain.MyClass115;
import big.domain.MyClass50;
import big.repositories.criteria.MyClass115Criteria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass115.class)
public class MyClass115SearchController
{

	
	@Autowired
	private MyClass115Service myClass115Service;
	
	@Autowired
	private MyClass50Service myClass50Service;
    

	@ModelAttribute(value = "myclass50s")
	public List<MyClass50> getMyClass50s () 
	{
		return this.myClass50Service.findAll();	
	}

	@RequestMapping(value = "/myclass115/list", method = RequestMethod.GET)
	public List<MyClass115> list (Model model) 
	{
		MyClass115Criteria myClass115Criteria = new MyClass115Criteria();
		model.addAttribute(myClass115Criteria);
		return this.myClass115Service.findAll();	
	}

	@RequestMapping(value = "/myclass115/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass115> search (@ModelAttribute MyClass115Criteria criteria) 
	{
		return this.myClass115Service.findByCriteria(criteria);	
	}


}
