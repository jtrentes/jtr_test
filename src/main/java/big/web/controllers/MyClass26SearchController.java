package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass26Criteria;
import java.util.List;
import big.domain.MyClass26;
import org.springframework.ui.Model;
import big.services.MyClass26Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass26.class)
public class MyClass26SearchController
{

	
	@Autowired
	private MyClass26Service myClass26Service;
    

	@RequestMapping(value = "/myclass26/list", method = RequestMethod.GET)
	public List<MyClass26> list (Model model) 
	{
		MyClass26Criteria myClass26Criteria = new MyClass26Criteria();
		model.addAttribute(myClass26Criteria);
		return this.myClass26Service.findAll();	
	}

	@RequestMapping(value = "/myclass26/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass26> search (@ModelAttribute MyClass26Criteria criteria) 
	{
		return this.myClass26Service.findByCriteria(criteria);	
	}


}
