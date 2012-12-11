package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass53Criteria;
import big.services.MyClass53Service;
import big.domain.MyClass53;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass53.class)
public class MyClass53SearchController
{

	
	@Autowired
	private MyClass53Service myClass53Service;
    

	@RequestMapping(value = "/myclass53/list", method = RequestMethod.GET)
	public List<MyClass53> list (Model model) 
	{
		MyClass53Criteria myClass53Criteria = new MyClass53Criteria();
		model.addAttribute(myClass53Criteria);
		return this.myClass53Service.findAll();	
	}

	@RequestMapping(value = "/myclass53/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass53> search (@ModelAttribute MyClass53Criteria criteria) 
	{
		return this.myClass53Service.findByCriteria(criteria);	
	}


}
