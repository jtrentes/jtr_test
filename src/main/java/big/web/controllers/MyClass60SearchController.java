package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass60Service;
import java.util.List;
import big.domain.MyClass60;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass60Criteria;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass60.class)
public class MyClass60SearchController
{

	
	@Autowired
	private MyClass60Service myClass60Service;
    

	@RequestMapping(value = "/myclass60/list", method = RequestMethod.GET)
	public List<MyClass60> list (Model model) 
	{
		MyClass60Criteria myClass60Criteria = new MyClass60Criteria();
		model.addAttribute(myClass60Criteria);
		return this.myClass60Service.findAll();	
	}

	@RequestMapping(value = "/myclass60/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass60> search (@ModelAttribute MyClass60Criteria criteria) 
	{
		return this.myClass60Service.findByCriteria(criteria);	
	}


}
