package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass140Service;
import big.domain.MyClass140;
import java.util.List;
import org.springframework.ui.Model;
import big.services.MyClass97Service;
import big.repositories.criteria.MyClass140Criteria;
import big.domain.MyClass97;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass140.class)
public class MyClass140SearchController
{

	
	@Autowired
	private MyClass140Service myClass140Service;
	
	@Autowired
	private MyClass97Service myClass97Service;
    

	@ModelAttribute(value = "myclass97s")
	public List<MyClass97> getMyClass97s () 
	{
		return this.myClass97Service.findAll();	
	}

	@RequestMapping(value = "/myclass140/list", method = RequestMethod.GET)
	public List<MyClass140> list (Model model) 
	{
		MyClass140Criteria myClass140Criteria = new MyClass140Criteria();
		model.addAttribute(myClass140Criteria);
		return this.myClass140Service.findAll();	
	}

	@RequestMapping(value = "/myclass140/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass140> search (@ModelAttribute MyClass140Criteria criteria) 
	{
		return this.myClass140Service.findByCriteria(criteria);	
	}


}
