package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass73Service;
import big.repositories.criteria.MyClass73Criteria;
import java.util.List;
import big.domain.MyClass73;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass73.class)
public class MyClass73SearchController
{

	
	@Autowired
	private MyClass73Service myClass73Service;
    

	@RequestMapping(value = "/myclass73/list", method = RequestMethod.GET)
	public List<MyClass73> list (Model model) 
	{
		MyClass73Criteria myClass73Criteria = new MyClass73Criteria();
		model.addAttribute(myClass73Criteria);
		return this.myClass73Service.findAll();	
	}

	@RequestMapping(value = "/myclass73/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass73> search (@ModelAttribute MyClass73Criteria criteria) 
	{
		return this.myClass73Service.findByCriteria(criteria);	
	}


}
