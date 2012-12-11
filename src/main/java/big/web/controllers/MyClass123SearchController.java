package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass123Service;
import big.repositories.criteria.MyClass123Criteria;
import org.springframework.ui.Model;
import big.domain.MyClass123;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass123.class)
public class MyClass123SearchController
{

	
	@Autowired
	private MyClass123Service myClass123Service;
    

	@RequestMapping(value = "/myclass123/list", method = RequestMethod.GET)
	public List<MyClass123> list (Model model) 
	{
		MyClass123Criteria myClass123Criteria = new MyClass123Criteria();
		model.addAttribute(myClass123Criteria);
		return this.myClass123Service.findAll();	
	}

	@RequestMapping(value = "/myclass123/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass123> search (@ModelAttribute MyClass123Criteria criteria) 
	{
		return this.myClass123Service.findByCriteria(criteria);	
	}


}
