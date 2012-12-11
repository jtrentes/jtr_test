package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass147Criteria;
import java.util.List;
import big.services.MyClass147Service;
import org.springframework.ui.Model;
import big.domain.MyClass147;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass147.class)
public class MyClass147SearchController
{

	
	@Autowired
	private MyClass147Service myClass147Service;
    

	@RequestMapping(value = "/myclass147/list", method = RequestMethod.GET)
	public List<MyClass147> list (Model model) 
	{
		MyClass147Criteria myClass147Criteria = new MyClass147Criteria();
		model.addAttribute(myClass147Criteria);
		return this.myClass147Service.findAll();	
	}

	@RequestMapping(value = "/myclass147/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass147> search (@ModelAttribute MyClass147Criteria criteria) 
	{
		return this.myClass147Service.findByCriteria(criteria);	
	}


}
