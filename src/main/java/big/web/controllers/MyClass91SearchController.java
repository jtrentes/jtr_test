package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass91;
import big.repositories.criteria.MyClass91Criteria;
import org.springframework.ui.Model;
import big.services.MyClass91Service;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass91.class)
public class MyClass91SearchController
{

	
	@Autowired
	private MyClass91Service myClass91Service;
    

	@RequestMapping(value = "/myclass91/list", method = RequestMethod.GET)
	public List<MyClass91> list (Model model) 
	{
		MyClass91Criteria myClass91Criteria = new MyClass91Criteria();
		model.addAttribute(myClass91Criteria);
		return this.myClass91Service.findAll();	
	}

	@RequestMapping(value = "/myclass91/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass91> search (@ModelAttribute MyClass91Criteria criteria) 
	{
		return this.myClass91Service.findByCriteria(criteria);	
	}


}
