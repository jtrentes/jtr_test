package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass113;
import java.util.List;
import big.services.MyClass113Service;
import big.repositories.criteria.MyClass113Criteria;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass113.class)
public class MyClass113SearchController
{

	
	@Autowired
	private MyClass113Service myClass113Service;
    

	@RequestMapping(value = "/myclass113/list", method = RequestMethod.GET)
	public List<MyClass113> list (Model model) 
	{
		MyClass113Criteria myClass113Criteria = new MyClass113Criteria();
		model.addAttribute(myClass113Criteria);
		return this.myClass113Service.findAll();	
	}

	@RequestMapping(value = "/myclass113/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass113> search (@ModelAttribute MyClass113Criteria criteria) 
	{
		return this.myClass113Service.findByCriteria(criteria);	
	}


}
