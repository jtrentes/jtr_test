package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass24Service;
import big.domain.MyClass24;
import big.repositories.criteria.MyClass24Criteria;
import java.util.List;
import org.springframework.ui.Model;
import big.services.MyClass6Service;
import big.domain.MyClass6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass24.class)
public class MyClass24SearchController
{

	
	@Autowired
	private MyClass24Service myClass24Service;
	
	@Autowired
	private MyClass6Service myClass6Service;
    

	@ModelAttribute(value = "myclass6s")
	public List<MyClass6> getMyClass6s () 
	{
		return this.myClass6Service.findAll();	
	}

	@RequestMapping(value = "/myclass24/list", method = RequestMethod.GET)
	public List<MyClass24> list (Model model) 
	{
		MyClass24Criteria myClass24Criteria = new MyClass24Criteria();
		model.addAttribute(myClass24Criteria);
		return this.myClass24Service.findAll();	
	}

	@RequestMapping(value = "/myclass24/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass24> search (@ModelAttribute MyClass24Criteria criteria) 
	{
		return this.myClass24Service.findByCriteria(criteria);	
	}


}
