package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass155;
import big.services.MyClass39Service;
import org.springframework.ui.Model;
import big.services.MyClass155Service;
import java.util.List;
import big.domain.MyClass39;
import big.repositories.criteria.MyClass155Criteria;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass155.class)
public class MyClass155SearchController
{

	
	@Autowired
	private MyClass155Service myClass155Service;
	
	@Autowired
	private MyClass39Service myClass39Service;
    

	@ModelAttribute(value = "myclass39s")
	public List<MyClass39> getMyClass39s () 
	{
		return this.myClass39Service.findAll();	
	}

	@RequestMapping(value = "/myclass155/list", method = RequestMethod.GET)
	public List<MyClass155> list (Model model) 
	{
		MyClass155Criteria myClass155Criteria = new MyClass155Criteria();
		model.addAttribute(myClass155Criteria);
		return this.myClass155Service.findAll();	
	}

	@RequestMapping(value = "/myclass155/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass155> search (@ModelAttribute MyClass155Criteria criteria) 
	{
		return this.myClass155Service.findByCriteria(criteria);	
	}


}
