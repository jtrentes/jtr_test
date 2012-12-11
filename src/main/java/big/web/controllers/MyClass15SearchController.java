package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass15Criteria;
import java.util.List;
import big.domain.MyClass15;
import big.services.MyClass15Service;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass15.class)
public class MyClass15SearchController
{

	
	@Autowired
	private MyClass15Service myClass15Service;
    

	@RequestMapping(value = "/myclass15/list", method = RequestMethod.GET)
	public List<MyClass15> list (Model model) 
	{
		MyClass15Criteria myClass15Criteria = new MyClass15Criteria();
		model.addAttribute(myClass15Criteria);
		return this.myClass15Service.findAll();	
	}

	@RequestMapping(value = "/myclass15/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass15> search (@ModelAttribute MyClass15Criteria criteria) 
	{
		return this.myClass15Service.findByCriteria(criteria);	
	}


}
