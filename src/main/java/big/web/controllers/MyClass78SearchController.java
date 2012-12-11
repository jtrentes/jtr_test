package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.domain.MyClass78;
import big.domain.MyClass74;
import org.springframework.ui.Model;
import big.services.MyClass74Service;
import big.services.MyClass78Service;
import big.repositories.criteria.MyClass78Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass78.class)
public class MyClass78SearchController
{

	
	@Autowired
	private MyClass74Service myClass74Service;
	
	@Autowired
	private MyClass78Service myClass78Service;
    

	@ModelAttribute(value = "myclass74s")
	public List<MyClass74> getMyClass74s () 
	{
		return this.myClass74Service.findAll();	
	}

	@RequestMapping(value = "/myclass78/list", method = RequestMethod.GET)
	public List<MyClass78> list (Model model) 
	{
		MyClass78Criteria myClass78Criteria = new MyClass78Criteria();
		model.addAttribute(myClass78Criteria);
		return this.myClass78Service.findAll();	
	}

	@RequestMapping(value = "/myclass78/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass78> search (@ModelAttribute MyClass78Criteria criteria) 
	{
		return this.myClass78Service.findByCriteria(criteria);	
	}


}
