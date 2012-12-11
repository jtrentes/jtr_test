package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass48;
import big.services.MyClass48Service;
import java.util.List;
import big.repositories.criteria.MyClass48Criteria;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass48.class)
public class MyClass48SearchController
{

	
	@Autowired
	private MyClass48Service myClass48Service;
    

	@RequestMapping(value = "/myclass48/list", method = RequestMethod.GET)
	public List<MyClass48> list (Model model) 
	{
		MyClass48Criteria myClass48Criteria = new MyClass48Criteria();
		model.addAttribute(myClass48Criteria);
		return this.myClass48Service.findAll();	
	}

	@RequestMapping(value = "/myclass48/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass48> search (@ModelAttribute MyClass48Criteria criteria) 
	{
		return this.myClass48Service.findByCriteria(criteria);	
	}


}
