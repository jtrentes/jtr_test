package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.domain.MyClass28;
import org.springframework.ui.Model;
import big.services.MyClass23Service;
import big.services.MyClass28Service;
import big.repositories.criteria.MyClass23Criteria;
import big.domain.MyClass23;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass23.class)
public class MyClass23SearchController
{

	
	@Autowired
	private MyClass23Service myClass23Service;
	
	@Autowired
	private MyClass28Service myClass28Service;
    

	@ModelAttribute(value = "myclass28s")
	public List<MyClass28> getMyClass28s () 
	{
		return this.myClass28Service.findAll();	
	}

	@RequestMapping(value = "/myclass23/list", method = RequestMethod.GET)
	public List<MyClass23> list (Model model) 
	{
		MyClass23Criteria myClass23Criteria = new MyClass23Criteria();
		model.addAttribute(myClass23Criteria);
		return this.myClass23Service.findAll();	
	}

	@RequestMapping(value = "/myclass23/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass23> search (@ModelAttribute MyClass23Criteria criteria) 
	{
		return this.myClass23Service.findByCriteria(criteria);	
	}


}
