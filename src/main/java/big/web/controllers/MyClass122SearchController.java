package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import java.util.List;
import big.repositories.criteria.MyClass122Criteria;
import big.domain.MyClass122;
import big.services.MyClass122Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass122.class)
public class MyClass122SearchController
{

	
	@Autowired
	private MyClass122Service myClass122Service;
    

	@RequestMapping(value = "/myclass122/list", method = RequestMethod.GET)
	public List<MyClass122> list (Model model) 
	{
		MyClass122Criteria myClass122Criteria = new MyClass122Criteria();
		model.addAttribute(myClass122Criteria);
		return this.myClass122Service.findAll();	
	}

	@RequestMapping(value = "/myclass122/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass122> search (@ModelAttribute MyClass122Criteria criteria) 
	{
		return this.myClass122Service.findByCriteria(criteria);	
	}


}
