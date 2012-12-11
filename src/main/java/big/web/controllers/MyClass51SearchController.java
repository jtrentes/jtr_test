package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass51Service;
import java.util.List;
import big.repositories.criteria.MyClass51Criteria;
import big.services.MyClass17Service;
import org.springframework.ui.Model;
import big.domain.MyClass17;
import big.domain.MyClass51;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass51.class)
public class MyClass51SearchController
{

	
	@Autowired
	private MyClass17Service myClass17Service;
	
	@Autowired
	private MyClass51Service myClass51Service;
    

	@ModelAttribute(value = "myclass17s")
	public List<MyClass17> getMyClass17s () 
	{
		return this.myClass17Service.findAll();	
	}

	@RequestMapping(value = "/myclass51/list", method = RequestMethod.GET)
	public List<MyClass51> list (Model model) 
	{
		MyClass51Criteria myClass51Criteria = new MyClass51Criteria();
		model.addAttribute(myClass51Criteria);
		return this.myClass51Service.findAll();	
	}

	@RequestMapping(value = "/myclass51/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass51> search (@ModelAttribute MyClass51Criteria criteria) 
	{
		return this.myClass51Service.findByCriteria(criteria);	
	}


}
