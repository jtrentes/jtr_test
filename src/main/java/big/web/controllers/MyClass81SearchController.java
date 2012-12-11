package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass81Service;
import big.domain.MyClass81;
import java.util.List;
import big.services.MyClass163Service;
import big.domain.MyClass163;
import big.repositories.criteria.MyClass81Criteria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass81.class)
public class MyClass81SearchController
{

	
	@Autowired
	private MyClass163Service myClass163Service;
	
	@Autowired
	private MyClass81Service myClass81Service;
    

	@ModelAttribute(value = "myclass163s")
	public List<MyClass163> getMyClass163s () 
	{
		return this.myClass163Service.findAll();	
	}

	@RequestMapping(value = "/myclass81/list", method = RequestMethod.GET)
	public List<MyClass81> list (Model model) 
	{
		MyClass81Criteria myClass81Criteria = new MyClass81Criteria();
		model.addAttribute(myClass81Criteria);
		return this.myClass81Service.findAll();	
	}

	@RequestMapping(value = "/myclass81/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass81> search (@ModelAttribute MyClass81Criteria criteria) 
	{
		return this.myClass81Service.findByCriteria(criteria);	
	}


}
