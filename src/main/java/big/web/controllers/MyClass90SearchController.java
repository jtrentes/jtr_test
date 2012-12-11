package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.ui.Model;
import big.services.MyClass90Service;
import big.repositories.criteria.MyClass90Criteria;
import big.domain.MyClass90;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass90.class)
public class MyClass90SearchController
{

	
	@Autowired
	private MyClass90Service myClass90Service;
    

	@RequestMapping(value = "/myclass90/list", method = RequestMethod.GET)
	public List<MyClass90> list (Model model) 
	{
		MyClass90Criteria myClass90Criteria = new MyClass90Criteria();
		model.addAttribute(myClass90Criteria);
		return this.myClass90Service.findAll();	
	}

	@RequestMapping(value = "/myclass90/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass90> search (@ModelAttribute MyClass90Criteria criteria) 
	{
		return this.myClass90Service.findByCriteria(criteria);	
	}


}
