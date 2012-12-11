package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass69;
import big.services.MyClass7Service;
import big.domain.MyClass7;
import org.springframework.ui.Model;
import big.services.MyClass69Service;
import java.util.List;
import big.repositories.criteria.MyClass7Criteria;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass7.class)
public class MyClass7SearchController
{

	
	@Autowired
	private MyClass69Service myClass69Service;
	
	@Autowired
	private MyClass7Service myClass7Service;
    

	@ModelAttribute(value = "myclass69s")
	public List<MyClass69> getMyClass69s () 
	{
		return this.myClass69Service.findAll();	
	}

	@RequestMapping(value = "/myclass7/list", method = RequestMethod.GET)
	public List<MyClass7> list (Model model) 
	{
		MyClass7Criteria myClass7Criteria = new MyClass7Criteria();
		model.addAttribute(myClass7Criteria);
		return this.myClass7Service.findAll();	
	}

	@RequestMapping(value = "/myclass7/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass7> search (@ModelAttribute MyClass7Criteria criteria) 
	{
		return this.myClass7Service.findByCriteria(criteria);	
	}


}
