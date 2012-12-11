package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass62Criteria;
import big.services.MyClass63Service;
import big.domain.MyClass62;
import org.springframework.ui.Model;
import big.services.MyClass35Service;
import java.util.List;
import big.domain.MyClass63;
import big.domain.MyClass35;
import big.services.MyClass62Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass62.class)
public class MyClass62SearchController
{

	
	@Autowired
	private MyClass35Service myClass35Service;
	
	@Autowired
	private MyClass62Service myClass62Service;
	
	@Autowired
	private MyClass63Service myClass63Service;
    

	@ModelAttribute(value = "myclass35s")
	public List<MyClass35> getMyClass35s () 
	{
		return this.myClass35Service.findAll();	
	}

	@ModelAttribute(value = "myclass63s")
	public List<MyClass63> getMyClass63s () 
	{
		return this.myClass63Service.findAll();	
	}

	@RequestMapping(value = "/myclass62/list", method = RequestMethod.GET)
	public List<MyClass62> list (Model model) 
	{
		MyClass62Criteria myClass62Criteria = new MyClass62Criteria();
		model.addAttribute(myClass62Criteria);
		return this.myClass62Service.findAll();	
	}

	@RequestMapping(value = "/myclass62/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass62> search (@ModelAttribute MyClass62Criteria criteria) 
	{
		return this.myClass62Service.findByCriteria(criteria);	
	}


}
