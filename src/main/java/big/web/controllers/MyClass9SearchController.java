package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass9Service;
import big.repositories.criteria.MyClass9Criteria;
import big.domain.MyClass81;
import big.services.MyClass81Service;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass9;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass9.class)
public class MyClass9SearchController
{

	
	@Autowired
	private MyClass81Service myClass81Service;
	
	@Autowired
	private MyClass9Service myClass9Service;
    

	@ModelAttribute(value = "myclass81s")
	public List<MyClass81> getMyClass81s () 
	{
		return this.myClass81Service.findAll();	
	}

	@RequestMapping(value = "/myclass9/list", method = RequestMethod.GET)
	public List<MyClass9> list (Model model) 
	{
		MyClass9Criteria myClass9Criteria = new MyClass9Criteria();
		model.addAttribute(myClass9Criteria);
		return this.myClass9Service.findAll();	
	}

	@RequestMapping(value = "/myclass9/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass9> search (@ModelAttribute MyClass9Criteria criteria) 
	{
		return this.myClass9Service.findByCriteria(criteria);	
	}


}
