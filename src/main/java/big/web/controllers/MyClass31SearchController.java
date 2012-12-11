package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.services.MyClass31Service;
import big.repositories.criteria.MyClass31Criteria;
import org.springframework.ui.Model;
import big.domain.MyClass31;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass31.class)
public class MyClass31SearchController
{

	
	@Autowired
	private MyClass31Service myClass31Service;
    

	@RequestMapping(value = "/myclass31/list", method = RequestMethod.GET)
	public List<MyClass31> list (Model model) 
	{
		MyClass31Criteria myClass31Criteria = new MyClass31Criteria();
		model.addAttribute(myClass31Criteria);
		return this.myClass31Service.findAll();	
	}

	@RequestMapping(value = "/myclass31/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass31> search (@ModelAttribute MyClass31Criteria criteria) 
	{
		return this.myClass31Service.findByCriteria(criteria);	
	}


}
