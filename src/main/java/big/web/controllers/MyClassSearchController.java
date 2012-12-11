package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClassService;
import big.domain.MyClass2;
import big.services.MyClass2Service;
import big.domain.MyClass;
import big.repositories.criteria.MyClassCriteria;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass.class)
public class MyClassSearchController
{

	
	@Autowired
	private MyClass2Service myClass2Service;
	
	@Autowired
	private MyClassService myClassService;
    

	@ModelAttribute(value = "myclass2s")
	public List<MyClass2> getMyClass2s () 
	{
		return this.myClass2Service.findAll();	
	}

	@RequestMapping(value = "/myclass/list", method = RequestMethod.GET)
	public List<MyClass> list (Model model) 
	{
		MyClassCriteria myClassCriteria = new MyClassCriteria();
		model.addAttribute(myClassCriteria);
		return this.myClassService.findAll();	
	}

	@RequestMapping(value = "/myclass/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass> search (@ModelAttribute MyClassCriteria criteria) 
	{
		return this.myClassService.findByCriteria(criteria);	
	}


}
