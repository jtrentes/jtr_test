package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass51;
import java.util.List;
import big.services.MyClass51Service;
import big.repositories.criteria.MyClass35Criteria;
import big.services.MyClass35Service;
import big.domain.MyClass35;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass35.class)
public class MyClass35SearchController
{

	
	@Autowired
	private MyClass35Service myClass35Service;
	
	@Autowired
	private MyClass51Service myClass51Service;
    

	@ModelAttribute(value = "myclass51s")
	public List<MyClass51> getMyClass51s () 
	{
		return this.myClass51Service.findAll();	
	}

	@RequestMapping(value = "/myclass35/list", method = RequestMethod.GET)
	public List<MyClass35> list (Model model) 
	{
		MyClass35Criteria myClass35Criteria = new MyClass35Criteria();
		model.addAttribute(myClass35Criteria);
		return this.myClass35Service.findAll();	
	}

	@RequestMapping(value = "/myclass35/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass35> search (@ModelAttribute MyClass35Criteria criteria) 
	{
		return this.myClass35Service.findByCriteria(criteria);	
	}


}
