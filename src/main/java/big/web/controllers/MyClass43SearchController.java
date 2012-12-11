package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass34Service;
import big.domain.MyClass43;
import big.services.MyClass43Service;
import big.domain.MyClass34;
import java.util.List;
import big.repositories.criteria.MyClass43Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass43.class)
public class MyClass43SearchController
{

	
	@Autowired
	private MyClass34Service myClass34Service;
	
	@Autowired
	private MyClass43Service myClass43Service;
    

	@ModelAttribute(value = "myclass34s")
	public List<MyClass34> getMyClass34s () 
	{
		return this.myClass34Service.findAll();	
	}

	@RequestMapping(value = "/myclass43/list", method = RequestMethod.GET)
	public List<MyClass43> list (Model model) 
	{
		MyClass43Criteria myClass43Criteria = new MyClass43Criteria();
		model.addAttribute(myClass43Criteria);
		return this.myClass43Service.findAll();	
	}

	@RequestMapping(value = "/myclass43/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass43> search (@ModelAttribute MyClass43Criteria criteria) 
	{
		return this.myClass43Service.findByCriteria(criteria);	
	}


}
