package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass30;
import big.domain.MyClass120;
import big.repositories.criteria.MyClass120Criteria;
import big.services.MyClass30Service;
import java.util.List;
import big.services.MyClass120Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass120.class)
public class MyClass120SearchController
{

	
	@Autowired
	private MyClass120Service myClass120Service;
	
	@Autowired
	private MyClass30Service myClass30Service;
    

	@ModelAttribute(value = "myclass30s")
	public List<MyClass30> getMyClass30s () 
	{
		return this.myClass30Service.findAll();	
	}

	@RequestMapping(value = "/myclass120/list", method = RequestMethod.GET)
	public List<MyClass120> list (Model model) 
	{
		MyClass120Criteria myClass120Criteria = new MyClass120Criteria();
		model.addAttribute(myClass120Criteria);
		return this.myClass120Service.findAll();	
	}

	@RequestMapping(value = "/myclass120/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass120> search (@ModelAttribute MyClass120Criteria criteria) 
	{
		return this.myClass120Service.findByCriteria(criteria);	
	}


}
