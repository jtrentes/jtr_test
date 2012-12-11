package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass7;
import org.springframework.ui.Model;
import big.services.MyClass8Service;
import big.repositories.criteria.MyClass8Criteria;
import big.services.MyClass7Service;
import big.domain.MyClass8;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass8.class)
public class MyClass8SearchController
{

	
	@Autowired
	private MyClass7Service myClass7Service;
	
	@Autowired
	private MyClass8Service myClass8Service;
    

	@ModelAttribute(value = "myclass7s")
	public List<MyClass7> getMyClass7s () 
	{
		return this.myClass7Service.findAll();	
	}

	@RequestMapping(value = "/myclass8/list", method = RequestMethod.GET)
	public List<MyClass8> list (Model model) 
	{
		MyClass8Criteria myClass8Criteria = new MyClass8Criteria();
		model.addAttribute(myClass8Criteria);
		return this.myClass8Service.findAll();	
	}

	@RequestMapping(value = "/myclass8/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass8> search (@ModelAttribute MyClass8Criteria criteria) 
	{
		return this.myClass8Service.findByCriteria(criteria);	
	}


}
