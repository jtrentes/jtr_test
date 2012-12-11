package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass67Criteria;
import big.domain.MyClass67;
import java.util.List;
import big.services.MyClass67Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass67.class)
public class MyClass67SearchController
{

	
	@Autowired
	private MyClass67Service myClass67Service;
    

	@RequestMapping(value = "/myclass67/list", method = RequestMethod.GET)
	public List<MyClass67> list (Model model) 
	{
		MyClass67Criteria myClass67Criteria = new MyClass67Criteria();
		model.addAttribute(myClass67Criteria);
		return this.myClass67Service.findAll();	
	}

	@RequestMapping(value = "/myclass67/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass67> search (@ModelAttribute MyClass67Criteria criteria) 
	{
		return this.myClass67Service.findByCriteria(criteria);	
	}


}
