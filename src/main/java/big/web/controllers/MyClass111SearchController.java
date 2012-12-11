package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass111Criteria;
import org.springframework.ui.Model;
import big.domain.MyClass23;
import big.services.MyClass111Service;
import java.util.List;
import big.domain.MyClass111;
import big.services.MyClass23Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass111.class)
public class MyClass111SearchController
{

	
	@Autowired
	private MyClass111Service myClass111Service;
	
	@Autowired
	private MyClass23Service myClass23Service;
    

	@ModelAttribute(value = "myclass23s")
	public List<MyClass23> getMyClass23s () 
	{
		return this.myClass23Service.findAll();	
	}

	@RequestMapping(value = "/myclass111/list", method = RequestMethod.GET)
	public List<MyClass111> list (Model model) 
	{
		MyClass111Criteria myClass111Criteria = new MyClass111Criteria();
		model.addAttribute(myClass111Criteria);
		return this.myClass111Service.findAll();	
	}

	@RequestMapping(value = "/myclass111/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass111> search (@ModelAttribute MyClass111Criteria criteria) 
	{
		return this.myClass111Service.findByCriteria(criteria);	
	}


}
