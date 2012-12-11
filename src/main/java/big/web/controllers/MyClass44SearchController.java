package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass44;
import java.util.List;
import big.services.MyClass44Service;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass44Criteria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass44.class)
public class MyClass44SearchController
{

	
	@Autowired
	private MyClass44Service myClass44Service;
    

	@RequestMapping(value = "/myclass44/list", method = RequestMethod.GET)
	public List<MyClass44> list (Model model) 
	{
		MyClass44Criteria myClass44Criteria = new MyClass44Criteria();
		model.addAttribute(myClass44Criteria);
		return this.myClass44Service.findAll();	
	}

	@RequestMapping(value = "/myclass44/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass44> search (@ModelAttribute MyClass44Criteria criteria) 
	{
		return this.myClass44Service.findByCriteria(criteria);	
	}


}
