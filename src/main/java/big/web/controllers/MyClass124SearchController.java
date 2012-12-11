package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass124Criteria;
import big.domain.MyClass124;
import big.services.MyClass140Service;
import org.springframework.ui.Model;
import big.services.MyClass124Service;
import big.domain.MyClass140;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass124.class)
public class MyClass124SearchController
{

	
	@Autowired
	private MyClass124Service myClass124Service;
	
	@Autowired
	private MyClass140Service myClass140Service;
    

	@ModelAttribute(value = "myclass140s")
	public List<MyClass140> getMyClass140s () 
	{
		return this.myClass140Service.findAll();	
	}

	@RequestMapping(value = "/myclass124/list", method = RequestMethod.GET)
	public List<MyClass124> list (Model model) 
	{
		MyClass124Criteria myClass124Criteria = new MyClass124Criteria();
		model.addAttribute(myClass124Criteria);
		return this.myClass124Service.findAll();	
	}

	@RequestMapping(value = "/myclass124/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass124> search (@ModelAttribute MyClass124Criteria criteria) 
	{
		return this.myClass124Service.findByCriteria(criteria);	
	}


}
