package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass66Service;
import big.domain.MyClass66;
import big.repositories.criteria.MyClass66Criteria;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass66.class)
public class MyClass66SearchController
{

	
	@Autowired
	private MyClass66Service myClass66Service;
    

	@RequestMapping(value = "/myclass66/list", method = RequestMethod.GET)
	public List<MyClass66> list (Model model) 
	{
		MyClass66Criteria myClass66Criteria = new MyClass66Criteria();
		model.addAttribute(myClass66Criteria);
		return this.myClass66Service.findAll();	
	}

	@RequestMapping(value = "/myclass66/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass66> search (@ModelAttribute MyClass66Criteria criteria) 
	{
		return this.myClass66Service.findByCriteria(criteria);	
	}


}
