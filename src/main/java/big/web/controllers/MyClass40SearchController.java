package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass40Criteria;
import big.domain.MyClass40;
import big.services.MyClass40Service;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass40.class)
public class MyClass40SearchController
{

	
	@Autowired
	private MyClass40Service myClass40Service;
    

	@RequestMapping(value = "/myclass40/list", method = RequestMethod.GET)
	public List<MyClass40> list (Model model) 
	{
		MyClass40Criteria myClass40Criteria = new MyClass40Criteria();
		model.addAttribute(myClass40Criteria);
		return this.myClass40Service.findAll();	
	}

	@RequestMapping(value = "/myclass40/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass40> search (@ModelAttribute MyClass40Criteria criteria) 
	{
		return this.myClass40Service.findByCriteria(criteria);	
	}


}
