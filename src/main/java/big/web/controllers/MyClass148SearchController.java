package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass148;
import big.services.MyClass148Service;
import java.util.List;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass148Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass148.class)
public class MyClass148SearchController
{

	
	@Autowired
	private MyClass148Service myClass148Service;
    

	@RequestMapping(value = "/myclass148/list", method = RequestMethod.GET)
	public List<MyClass148> list (Model model) 
	{
		MyClass148Criteria myClass148Criteria = new MyClass148Criteria();
		model.addAttribute(myClass148Criteria);
		return this.myClass148Service.findAll();	
	}

	@RequestMapping(value = "/myclass148/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass148> search (@ModelAttribute MyClass148Criteria criteria) 
	{
		return this.myClass148Service.findByCriteria(criteria);	
	}


}
