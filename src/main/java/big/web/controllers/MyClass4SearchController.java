package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass4Criteria;
import big.services.MyClassService;
import big.domain.MyClass4;
import big.domain.MyClass;
import org.springframework.ui.Model;
import java.util.List;
import big.services.MyClass4Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass4.class)
public class MyClass4SearchController
{

	
	@Autowired
	private MyClass4Service myClass4Service;
	
	@Autowired
	private MyClassService myClassService;
    

	@ModelAttribute(value = "myclasss")
	public List<MyClass> getMyClasss () 
	{
		return this.myClassService.findAll();	
	}

	@RequestMapping(value = "/myclass4/list", method = RequestMethod.GET)
	public List<MyClass4> list (Model model) 
	{
		MyClass4Criteria myClass4Criteria = new MyClass4Criteria();
		model.addAttribute(myClass4Criteria);
		return this.myClass4Service.findAll();	
	}

	@RequestMapping(value = "/myclass4/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass4> search (@ModelAttribute MyClass4Criteria criteria) 
	{
		return this.myClass4Service.findByCriteria(criteria);	
	}


}
