package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.domain.MyClass136;
import big.services.MyClass136Service;
import big.repositories.criteria.MyClass136Criteria;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass136.class)
public class MyClass136SearchController
{

	
	@Autowired
	private MyClass136Service myClass136Service;
    

	@RequestMapping(value = "/myclass136/list", method = RequestMethod.GET)
	public List<MyClass136> list (Model model) 
	{
		MyClass136Criteria myClass136Criteria = new MyClass136Criteria();
		model.addAttribute(myClass136Criteria);
		return this.myClass136Service.findAll();	
	}

	@RequestMapping(value = "/myclass136/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass136> search (@ModelAttribute MyClass136Criteria criteria) 
	{
		return this.myClass136Service.findByCriteria(criteria);	
	}


}
