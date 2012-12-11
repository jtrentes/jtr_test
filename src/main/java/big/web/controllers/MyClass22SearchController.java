package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass22Criteria;
import big.services.MyClass22Service;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass22;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass22.class)
public class MyClass22SearchController
{

	
	@Autowired
	private MyClass22Service myClass22Service;
    

	@RequestMapping(value = "/myclass22/list", method = RequestMethod.GET)
	public List<MyClass22> list (Model model) 
	{
		MyClass22Criteria myClass22Criteria = new MyClass22Criteria();
		model.addAttribute(myClass22Criteria);
		return this.myClass22Service.findAll();	
	}

	@RequestMapping(value = "/myclass22/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass22> search (@ModelAttribute MyClass22Criteria criteria) 
	{
		return this.myClass22Service.findByCriteria(criteria);	
	}


}
