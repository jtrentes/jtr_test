package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.services.MyClass34Service;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass34Criteria;
import big.domain.MyClass34;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass34.class)
public class MyClass34SearchController
{

	
	@Autowired
	private MyClass34Service myClass34Service;
    

	@RequestMapping(value = "/myclass34/list", method = RequestMethod.GET)
	public List<MyClass34> list (Model model) 
	{
		MyClass34Criteria myClass34Criteria = new MyClass34Criteria();
		model.addAttribute(myClass34Criteria);
		return this.myClass34Service.findAll();	
	}

	@RequestMapping(value = "/myclass34/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass34> search (@ModelAttribute MyClass34Criteria criteria) 
	{
		return this.myClass34Service.findByCriteria(criteria);	
	}


}
