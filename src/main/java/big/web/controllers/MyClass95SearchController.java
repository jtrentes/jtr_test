package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass95;
import big.repositories.criteria.MyClass95Criteria;
import big.services.MyClass95Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass95.class)
public class MyClass95SearchController
{

	
	@Autowired
	private MyClass95Service myClass95Service;
    

	@RequestMapping(value = "/myclass95/list", method = RequestMethod.GET)
	public List<MyClass95> list (Model model) 
	{
		MyClass95Criteria myClass95Criteria = new MyClass95Criteria();
		model.addAttribute(myClass95Criteria);
		return this.myClass95Service.findAll();	
	}

	@RequestMapping(value = "/myclass95/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass95> search (@ModelAttribute MyClass95Criteria criteria) 
	{
		return this.myClass95Service.findByCriteria(criteria);	
	}


}
