package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass59;
import big.repositories.criteria.MyClass59Criteria;
import big.services.MyClass59Service;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass59.class)
public class MyClass59SearchController
{

	
	@Autowired
	private MyClass59Service myClass59Service;
    

	@RequestMapping(value = "/myclass59/list", method = RequestMethod.GET)
	public List<MyClass59> list (Model model) 
	{
		MyClass59Criteria myClass59Criteria = new MyClass59Criteria();
		model.addAttribute(myClass59Criteria);
		return this.myClass59Service.findAll();	
	}

	@RequestMapping(value = "/myclass59/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass59> search (@ModelAttribute MyClass59Criteria criteria) 
	{
		return this.myClass59Service.findByCriteria(criteria);	
	}


}
