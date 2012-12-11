package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass55;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass55Criteria;
import java.util.List;
import big.services.MyClass55Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass55.class)
public class MyClass55SearchController
{

	
	@Autowired
	private MyClass55Service myClass55Service;
    

	@RequestMapping(value = "/myclass55/list", method = RequestMethod.GET)
	public List<MyClass55> list (Model model) 
	{
		MyClass55Criteria myClass55Criteria = new MyClass55Criteria();
		model.addAttribute(myClass55Criteria);
		return this.myClass55Service.findAll();	
	}

	@RequestMapping(value = "/myclass55/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass55> search (@ModelAttribute MyClass55Criteria criteria) 
	{
		return this.myClass55Service.findByCriteria(criteria);	
	}


}
