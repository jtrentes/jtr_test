package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass70Service;
import big.repositories.criteria.MyClass69Criteria;
import big.domain.MyClass69;
import big.services.MyClass69Service;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass70;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass69.class)
public class MyClass69SearchController
{

	
	@Autowired
	private MyClass69Service myClass69Service;
	
	@Autowired
	private MyClass70Service myClass70Service;
    

	@ModelAttribute(value = "myclass70s")
	public List<MyClass70> getMyClass70s () 
	{
		return this.myClass70Service.findAll();	
	}

	@RequestMapping(value = "/myclass69/list", method = RequestMethod.GET)
	public List<MyClass69> list (Model model) 
	{
		MyClass69Criteria myClass69Criteria = new MyClass69Criteria();
		model.addAttribute(myClass69Criteria);
		return this.myClass69Service.findAll();	
	}

	@RequestMapping(value = "/myclass69/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass69> search (@ModelAttribute MyClass69Criteria criteria) 
	{
		return this.myClass69Service.findByCriteria(criteria);	
	}


}
