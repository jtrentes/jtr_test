package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass135Service;
import java.util.List;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass135Criteria;
import big.domain.MyClass135;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass135.class)
public class MyClass135SearchController
{

	
	@Autowired
	private MyClass135Service myClass135Service;
    

	@RequestMapping(value = "/myclass135/list", method = RequestMethod.GET)
	public List<MyClass135> list (Model model) 
	{
		MyClass135Criteria myClass135Criteria = new MyClass135Criteria();
		model.addAttribute(myClass135Criteria);
		return this.myClass135Service.findAll();	
	}

	@RequestMapping(value = "/myclass135/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass135> search (@ModelAttribute MyClass135Criteria criteria) 
	{
		return this.myClass135Service.findByCriteria(criteria);	
	}


}
