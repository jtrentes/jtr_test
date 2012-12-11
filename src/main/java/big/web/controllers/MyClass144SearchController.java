package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass144Service;
import big.repositories.criteria.MyClass144Criteria;
import big.domain.MyClass144;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass144.class)
public class MyClass144SearchController
{

	
	@Autowired
	private MyClass144Service myClass144Service;
    

	@RequestMapping(value = "/myclass144/list", method = RequestMethod.GET)
	public List<MyClass144> list (Model model) 
	{
		MyClass144Criteria myClass144Criteria = new MyClass144Criteria();
		model.addAttribute(myClass144Criteria);
		return this.myClass144Service.findAll();	
	}

	@RequestMapping(value = "/myclass144/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass144> search (@ModelAttribute MyClass144Criteria criteria) 
	{
		return this.myClass144Service.findByCriteria(criteria);	
	}


}
