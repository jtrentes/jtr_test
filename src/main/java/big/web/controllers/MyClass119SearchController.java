package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass119;
import big.repositories.criteria.MyClass119Criteria;
import big.services.MyClass119Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass119.class)
public class MyClass119SearchController
{

	
	@Autowired
	private MyClass119Service myClass119Service;
    

	@RequestMapping(value = "/myclass119/list", method = RequestMethod.GET)
	public List<MyClass119> list (Model model) 
	{
		MyClass119Criteria myClass119Criteria = new MyClass119Criteria();
		model.addAttribute(myClass119Criteria);
		return this.myClass119Service.findAll();	
	}

	@RequestMapping(value = "/myclass119/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass119> search (@ModelAttribute MyClass119Criteria criteria) 
	{
		return this.myClass119Service.findByCriteria(criteria);	
	}


}
