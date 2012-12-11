package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass27Service;
import big.domain.MyClass27;
import big.domain.MyClass24;
import big.repositories.criteria.MyClass27Criteria;
import org.springframework.ui.Model;
import big.services.MyClass24Service;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass27.class)
public class MyClass27SearchController
{

	
	@Autowired
	private MyClass24Service myClass24Service;
	
	@Autowired
	private MyClass27Service myClass27Service;
    

	@ModelAttribute(value = "myclass24s")
	public List<MyClass24> getMyClass24s () 
	{
		return this.myClass24Service.findAll();	
	}

	@RequestMapping(value = "/myclass27/list", method = RequestMethod.GET)
	public List<MyClass27> list (Model model) 
	{
		MyClass27Criteria myClass27Criteria = new MyClass27Criteria();
		model.addAttribute(myClass27Criteria);
		return this.myClass27Service.findAll();	
	}

	@RequestMapping(value = "/myclass27/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass27> search (@ModelAttribute MyClass27Criteria criteria) 
	{
		return this.myClass27Service.findByCriteria(criteria);	
	}


}
