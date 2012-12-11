package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass100Service;
import big.repositories.criteria.MyClass100Criteria;
import big.domain.MyClass100;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass100.class)
public class MyClass100SearchController
{

	
	@Autowired
	private MyClass100Service myClass100Service;
    

	@RequestMapping(value = "/myclass100/list", method = RequestMethod.GET)
	public List<MyClass100> list (Model model) 
	{
		MyClass100Criteria myClass100Criteria = new MyClass100Criteria();
		model.addAttribute(myClass100Criteria);
		return this.myClass100Service.findAll();	
	}

	@RequestMapping(value = "/myclass100/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass100> search (@ModelAttribute MyClass100Criteria criteria) 
	{
		return this.myClass100Service.findByCriteria(criteria);	
	}


}
