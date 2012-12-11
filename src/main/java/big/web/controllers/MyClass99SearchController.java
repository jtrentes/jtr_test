package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.domain.MyClass99;
import big.repositories.criteria.MyClass99Criteria;
import org.springframework.ui.Model;
import big.services.MyClass99Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass99.class)
public class MyClass99SearchController
{

	
	@Autowired
	private MyClass99Service myClass99Service;
    

	@RequestMapping(value = "/myclass99/list", method = RequestMethod.GET)
	public List<MyClass99> list (Model model) 
	{
		MyClass99Criteria myClass99Criteria = new MyClass99Criteria();
		model.addAttribute(myClass99Criteria);
		return this.myClass99Service.findAll();	
	}

	@RequestMapping(value = "/myclass99/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass99> search (@ModelAttribute MyClass99Criteria criteria) 
	{
		return this.myClass99Service.findByCriteria(criteria);	
	}


}
