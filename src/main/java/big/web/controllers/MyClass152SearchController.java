package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass152;
import big.repositories.criteria.MyClass152Criteria;
import big.services.MyClass152Service;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass152.class)
public class MyClass152SearchController
{

	
	@Autowired
	private MyClass152Service myClass152Service;
    

	@RequestMapping(value = "/myclass152/list", method = RequestMethod.GET)
	public List<MyClass152> list (Model model) 
	{
		MyClass152Criteria myClass152Criteria = new MyClass152Criteria();
		model.addAttribute(myClass152Criteria);
		return this.myClass152Service.findAll();	
	}

	@RequestMapping(value = "/myclass152/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass152> search (@ModelAttribute MyClass152Criteria criteria) 
	{
		return this.myClass152Service.findByCriteria(criteria);	
	}


}
