package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.ui.Model;
import big.services.MyClass96Service;
import big.domain.MyClass96;
import big.repositories.criteria.MyClass96Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass96.class)
public class MyClass96SearchController
{

	
	@Autowired
	private MyClass96Service myClass96Service;
    

	@RequestMapping(value = "/myclass96/list", method = RequestMethod.GET)
	public List<MyClass96> list (Model model) 
	{
		MyClass96Criteria myClass96Criteria = new MyClass96Criteria();
		model.addAttribute(myClass96Criteria);
		return this.myClass96Service.findAll();	
	}

	@RequestMapping(value = "/myclass96/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass96> search (@ModelAttribute MyClass96Criteria criteria) 
	{
		return this.myClass96Service.findByCriteria(criteria);	
	}


}
