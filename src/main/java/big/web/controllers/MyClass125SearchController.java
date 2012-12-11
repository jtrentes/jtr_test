package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.repositories.criteria.MyClass125Criteria;
import big.domain.MyClass125;
import org.springframework.ui.Model;
import big.services.MyClass125Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass125.class)
public class MyClass125SearchController
{

	
	@Autowired
	private MyClass125Service myClass125Service;
    

	@RequestMapping(value = "/myclass125/list", method = RequestMethod.GET)
	public List<MyClass125> list (Model model) 
	{
		MyClass125Criteria myClass125Criteria = new MyClass125Criteria();
		model.addAttribute(myClass125Criteria);
		return this.myClass125Service.findAll();	
	}

	@RequestMapping(value = "/myclass125/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass125> search (@ModelAttribute MyClass125Criteria criteria) 
	{
		return this.myClass125Service.findByCriteria(criteria);	
	}


}
