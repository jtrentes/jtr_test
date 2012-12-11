package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass42Service;
import big.repositories.criteria.MyClass42Criteria;
import org.springframework.ui.Model;
import big.domain.MyClass42;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass42.class)
public class MyClass42SearchController
{

	
	@Autowired
	private MyClass42Service myClass42Service;
    

	@RequestMapping(value = "/myclass42/list", method = RequestMethod.GET)
	public List<MyClass42> list (Model model) 
	{
		MyClass42Criteria myClass42Criteria = new MyClass42Criteria();
		model.addAttribute(myClass42Criteria);
		return this.myClass42Service.findAll();	
	}

	@RequestMapping(value = "/myclass42/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass42> search (@ModelAttribute MyClass42Criteria criteria) 
	{
		return this.myClass42Service.findByCriteria(criteria);	
	}


}
