package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass87;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass87Criteria;
import java.util.List;
import big.services.MyClass87Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass87.class)
public class MyClass87SearchController
{

	
	@Autowired
	private MyClass87Service myClass87Service;
    

	@RequestMapping(value = "/myclass87/list", method = RequestMethod.GET)
	public List<MyClass87> list (Model model) 
	{
		MyClass87Criteria myClass87Criteria = new MyClass87Criteria();
		model.addAttribute(myClass87Criteria);
		return this.myClass87Service.findAll();	
	}

	@RequestMapping(value = "/myclass87/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass87> search (@ModelAttribute MyClass87Criteria criteria) 
	{
		return this.myClass87Service.findByCriteria(criteria);	
	}


}
