package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass149Service;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass149Criteria;
import big.domain.MyClass149;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass149.class)
public class MyClass149SearchController
{

	
	@Autowired
	private MyClass149Service myClass149Service;
    

	@RequestMapping(value = "/myclass149/list", method = RequestMethod.GET)
	public List<MyClass149> list (Model model) 
	{
		MyClass149Criteria myClass149Criteria = new MyClass149Criteria();
		model.addAttribute(myClass149Criteria);
		return this.myClass149Service.findAll();	
	}

	@RequestMapping(value = "/myclass149/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass149> search (@ModelAttribute MyClass149Criteria criteria) 
	{
		return this.myClass149Service.findByCriteria(criteria);	
	}


}
