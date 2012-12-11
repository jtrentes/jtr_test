package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass30Service;
import big.domain.MyClass107;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass30;
import big.domain.MyClass31;
import big.services.MyClass31Service;
import big.services.MyClass107Service;
import big.repositories.criteria.MyClass30Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass30.class)
public class MyClass30SearchController
{

	
	@Autowired
	private MyClass107Service myClass107Service;
	
	@Autowired
	private MyClass30Service myClass30Service;
	
	@Autowired
	private MyClass31Service myClass31Service;
    

	@ModelAttribute(value = "myclass107s")
	public List<MyClass107> getMyClass107s () 
	{
		return this.myClass107Service.findAll();	
	}

	@ModelAttribute(value = "myclass31s")
	public List<MyClass31> getMyClass31s () 
	{
		return this.myClass31Service.findAll();	
	}

	@RequestMapping(value = "/myclass30/list", method = RequestMethod.GET)
	public List<MyClass30> list (Model model) 
	{
		MyClass30Criteria myClass30Criteria = new MyClass30Criteria();
		model.addAttribute(myClass30Criteria);
		return this.myClass30Service.findAll();	
	}

	@RequestMapping(value = "/myclass30/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass30> search (@ModelAttribute MyClass30Criteria criteria) 
	{
		return this.myClass30Service.findByCriteria(criteria);	
	}


}
