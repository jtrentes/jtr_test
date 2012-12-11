package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass61Criteria;
import big.domain.MyClass61;
import org.springframework.ui.Model;
import java.util.List;
import big.services.MyClass61Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass61.class)
public class MyClass61SearchController
{

	
	@Autowired
	private MyClass61Service myClass61Service;
    

	@RequestMapping(value = "/myclass61/list", method = RequestMethod.GET)
	public List<MyClass61> list (Model model) 
	{
		MyClass61Criteria myClass61Criteria = new MyClass61Criteria();
		model.addAttribute(myClass61Criteria);
		return this.myClass61Service.findAll();	
	}

	@RequestMapping(value = "/myclass61/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass61> search (@ModelAttribute MyClass61Criteria criteria) 
	{
		return this.myClass61Service.findByCriteria(criteria);	
	}


}
