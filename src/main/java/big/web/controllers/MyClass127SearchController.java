package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass127Criteria;
import org.springframework.ui.Model;
import big.services.MyClass127Service;
import java.util.List;
import big.domain.MyClass127;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass127.class)
public class MyClass127SearchController
{

	
	@Autowired
	private MyClass127Service myClass127Service;
    

	@RequestMapping(value = "/myclass127/list", method = RequestMethod.GET)
	public List<MyClass127> list (Model model) 
	{
		MyClass127Criteria myClass127Criteria = new MyClass127Criteria();
		model.addAttribute(myClass127Criteria);
		return this.myClass127Service.findAll();	
	}

	@RequestMapping(value = "/myclass127/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass127> search (@ModelAttribute MyClass127Criteria criteria) 
	{
		return this.myClass127Service.findByCriteria(criteria);	
	}


}
