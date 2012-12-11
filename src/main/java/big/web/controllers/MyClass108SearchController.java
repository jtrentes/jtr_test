package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass108Service;
import java.util.List;
import big.repositories.criteria.MyClass108Criteria;
import org.springframework.ui.Model;
import big.domain.MyClass108;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass108.class)
public class MyClass108SearchController
{

	
	@Autowired
	private MyClass108Service myClass108Service;
    

	@RequestMapping(value = "/myclass108/list", method = RequestMethod.GET)
	public List<MyClass108> list (Model model) 
	{
		MyClass108Criteria myClass108Criteria = new MyClass108Criteria();
		model.addAttribute(myClass108Criteria);
		return this.myClass108Service.findAll();	
	}

	@RequestMapping(value = "/myclass108/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass108> search (@ModelAttribute MyClass108Criteria criteria) 
	{
		return this.myClass108Service.findByCriteria(criteria);	
	}


}
