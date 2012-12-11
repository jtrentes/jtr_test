package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass63Service;
import big.domain.MyClass63;
import big.repositories.criteria.MyClass63Criteria;
import java.util.List;
import big.services.MyClass8Service;
import big.domain.MyClass8;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass63.class)
public class MyClass63SearchController
{

	
	@Autowired
	private MyClass63Service myClass63Service;
	
	@Autowired
	private MyClass8Service myClass8Service;
    

	@ModelAttribute(value = "myclass8s")
	public List<MyClass8> getMyClass8s () 
	{
		return this.myClass8Service.findAll();	
	}

	@RequestMapping(value = "/myclass63/list", method = RequestMethod.GET)
	public List<MyClass63> list (Model model) 
	{
		MyClass63Criteria myClass63Criteria = new MyClass63Criteria();
		model.addAttribute(myClass63Criteria);
		return this.myClass63Service.findAll();	
	}

	@RequestMapping(value = "/myclass63/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass63> search (@ModelAttribute MyClass63Criteria criteria) 
	{
		return this.myClass63Service.findByCriteria(criteria);	
	}


}
