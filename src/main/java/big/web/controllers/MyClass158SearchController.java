package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.repositories.criteria.MyClass158Criteria;
import big.domain.MyClass158;
import big.services.MyClass158Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass158.class)
public class MyClass158SearchController
{

	
	@Autowired
	private MyClass158Service myClass158Service;
    

	@RequestMapping(value = "/myclass158/list", method = RequestMethod.GET)
	public List<MyClass158> list (Model model) 
	{
		MyClass158Criteria myClass158Criteria = new MyClass158Criteria();
		model.addAttribute(myClass158Criteria);
		return this.myClass158Service.findAll();	
	}

	@RequestMapping(value = "/myclass158/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass158> search (@ModelAttribute MyClass158Criteria criteria) 
	{
		return this.myClass158Service.findByCriteria(criteria);	
	}


}
