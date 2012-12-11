package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass117;
import big.services.MyClass117Service;
import java.util.List;
import org.springframework.ui.Model;
import big.services.MyClass74Service;
import big.repositories.criteria.MyClass74Criteria;
import big.domain.MyClass74;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass74.class)
public class MyClass74SearchController
{

	
	@Autowired
	private MyClass117Service myClass117Service;
	
	@Autowired
	private MyClass74Service myClass74Service;
    

	@ModelAttribute(value = "myclass117s")
	public List<MyClass117> getMyClass117s () 
	{
		return this.myClass117Service.findAll();	
	}

	@RequestMapping(value = "/myclass74/list", method = RequestMethod.GET)
	public List<MyClass74> list (Model model) 
	{
		MyClass74Criteria myClass74Criteria = new MyClass74Criteria();
		model.addAttribute(myClass74Criteria);
		return this.myClass74Service.findAll();	
	}

	@RequestMapping(value = "/myclass74/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass74> search (@ModelAttribute MyClass74Criteria criteria) 
	{
		return this.myClass74Service.findByCriteria(criteria);	
	}


}
