package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.repositories.criteria.MyClass146Criteria;
import big.domain.MyClass146;
import big.services.MyClass146Service;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass146.class)
public class MyClass146SearchController
{

	
	@Autowired
	private MyClass146Service myClass146Service;
    

	@RequestMapping(value = "/myclass146/list", method = RequestMethod.GET)
	public List<MyClass146> list (Model model) 
	{
		MyClass146Criteria myClass146Criteria = new MyClass146Criteria();
		model.addAttribute(myClass146Criteria);
		return this.myClass146Service.findAll();	
	}

	@RequestMapping(value = "/myclass146/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass146> search (@ModelAttribute MyClass146Criteria criteria) 
	{
		return this.myClass146Service.findByCriteria(criteria);	
	}


}
