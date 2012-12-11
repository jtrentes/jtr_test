package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass75;
import org.springframework.ui.Model;
import big.services.MyClass75Service;
import java.util.List;
import big.repositories.criteria.MyClass75Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass75.class)
public class MyClass75SearchController
{

	
	@Autowired
	private MyClass75Service myClass75Service;
    

	@RequestMapping(value = "/myclass75/list", method = RequestMethod.GET)
	public List<MyClass75> list (Model model) 
	{
		MyClass75Criteria myClass75Criteria = new MyClass75Criteria();
		model.addAttribute(myClass75Criteria);
		return this.myClass75Service.findAll();	
	}

	@RequestMapping(value = "/myclass75/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass75> search (@ModelAttribute MyClass75Criteria criteria) 
	{
		return this.myClass75Service.findByCriteria(criteria);	
	}


}
