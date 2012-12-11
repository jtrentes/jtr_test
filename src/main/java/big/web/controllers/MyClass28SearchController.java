package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass28Criteria;
import org.springframework.ui.Model;
import big.services.MyClass25Service;
import big.domain.MyClass28;
import java.util.List;
import big.domain.MyClass25;
import big.services.MyClass115Service;
import big.services.MyClass28Service;
import big.domain.MyClass115;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass28.class)
public class MyClass28SearchController
{

	
	@Autowired
	private MyClass115Service myClass115Service;
	
	@Autowired
	private MyClass25Service myClass25Service;
	
	@Autowired
	private MyClass28Service myClass28Service;
    

	@ModelAttribute(value = "myclass115s")
	public List<MyClass115> getMyClass115s () 
	{
		return this.myClass115Service.findAll();	
	}

	@ModelAttribute(value = "myclass25s")
	public List<MyClass25> getMyClass25s () 
	{
		return this.myClass25Service.findAll();	
	}

	@RequestMapping(value = "/myclass28/list", method = RequestMethod.GET)
	public List<MyClass28> list (Model model) 
	{
		MyClass28Criteria myClass28Criteria = new MyClass28Criteria();
		model.addAttribute(myClass28Criteria);
		return this.myClass28Service.findAll();	
	}

	@RequestMapping(value = "/myclass28/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass28> search (@ModelAttribute MyClass28Criteria criteria) 
	{
		return this.myClass28Service.findByCriteria(criteria);	
	}


}
