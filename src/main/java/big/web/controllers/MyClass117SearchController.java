package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass58;
import org.springframework.ui.Model;
import big.services.MyClass117Service;
import java.util.List;
import big.services.MyClass58Service;
import big.domain.MyClass117;
import big.repositories.criteria.MyClass117Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass117.class)
public class MyClass117SearchController
{

	
	@Autowired
	private MyClass117Service myClass117Service;
	
	@Autowired
	private MyClass58Service myClass58Service;
    

	@ModelAttribute(value = "myclass58s")
	public List<MyClass58> getMyClass58s () 
	{
		return this.myClass58Service.findAll();	
	}

	@RequestMapping(value = "/myclass117/list", method = RequestMethod.GET)
	public List<MyClass117> list (Model model) 
	{
		MyClass117Criteria myClass117Criteria = new MyClass117Criteria();
		model.addAttribute(myClass117Criteria);
		return this.myClass117Service.findAll();	
	}

	@RequestMapping(value = "/myclass117/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass117> search (@ModelAttribute MyClass117Criteria criteria) 
	{
		return this.myClass117Service.findByCriteria(criteria);	
	}


}
