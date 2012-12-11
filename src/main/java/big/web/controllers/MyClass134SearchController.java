package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.services.MyClass134Service;
import big.repositories.criteria.MyClass134Criteria;
import org.springframework.ui.Model;
import big.domain.MyClass134;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass134.class)
public class MyClass134SearchController
{

	
	@Autowired
	private MyClass134Service myClass134Service;
    

	@RequestMapping(value = "/myclass134/list", method = RequestMethod.GET)
	public List<MyClass134> list (Model model) 
	{
		MyClass134Criteria myClass134Criteria = new MyClass134Criteria();
		model.addAttribute(myClass134Criteria);
		return this.myClass134Service.findAll();	
	}

	@RequestMapping(value = "/myclass134/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass134> search (@ModelAttribute MyClass134Criteria criteria) 
	{
		return this.myClass134Service.findByCriteria(criteria);	
	}


}
