package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass83Criteria;
import java.util.List;
import big.services.MyClass83Service;
import org.springframework.ui.Model;
import big.domain.MyClass83;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass83.class)
public class MyClass83SearchController
{

	
	@Autowired
	private MyClass83Service myClass83Service;
    

	@RequestMapping(value = "/myclass83/list", method = RequestMethod.GET)
	public List<MyClass83> list (Model model) 
	{
		MyClass83Criteria myClass83Criteria = new MyClass83Criteria();
		model.addAttribute(myClass83Criteria);
		return this.myClass83Service.findAll();	
	}

	@RequestMapping(value = "/myclass83/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass83> search (@ModelAttribute MyClass83Criteria criteria) 
	{
		return this.myClass83Service.findByCriteria(criteria);	
	}


}
