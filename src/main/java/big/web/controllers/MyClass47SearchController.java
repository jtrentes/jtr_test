package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass47Service;
import big.repositories.criteria.MyClass47Criteria;
import java.util.List;
import big.domain.MyClass47;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass47.class)
public class MyClass47SearchController
{

	
	@Autowired
	private MyClass47Service myClass47Service;
    

	@RequestMapping(value = "/myclass47/list", method = RequestMethod.GET)
	public List<MyClass47> list (Model model) 
	{
		MyClass47Criteria myClass47Criteria = new MyClass47Criteria();
		model.addAttribute(myClass47Criteria);
		return this.myClass47Service.findAll();	
	}

	@RequestMapping(value = "/myclass47/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass47> search (@ModelAttribute MyClass47Criteria criteria) 
	{
		return this.myClass47Service.findByCriteria(criteria);	
	}


}
