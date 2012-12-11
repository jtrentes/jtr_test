package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.services.MyClass79Service;
import big.domain.MyClass79;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass79Criteria;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass79.class)
public class MyClass79SearchController
{

	
	@Autowired
	private MyClass79Service myClass79Service;
    

	@RequestMapping(value = "/myclass79/list", method = RequestMethod.GET)
	public List<MyClass79> list (Model model) 
	{
		MyClass79Criteria myClass79Criteria = new MyClass79Criteria();
		model.addAttribute(myClass79Criteria);
		return this.myClass79Service.findAll();	
	}

	@RequestMapping(value = "/myclass79/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass79> search (@ModelAttribute MyClass79Criteria criteria) 
	{
		return this.myClass79Service.findByCriteria(criteria);	
	}


}
