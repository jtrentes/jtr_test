package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass2;
import java.util.List;
import big.services.MyClass2Service;
import big.domain.MyClass;
import big.repositories.criteria.MyClass2Criteria;
import big.services.MyClassService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass2.class)
public class MyClass2SearchController
{

	
	@Autowired
	private MyClass2Service myClass2Service;
	
	@Autowired
	private MyClassService myClassService;
    

	@ModelAttribute(value = "myclasss")
	public List<MyClass> getMyClasss () 
	{
		return this.myClassService.findAll();	
	}

	@RequestMapping(value = "/myclass2/list", method = RequestMethod.GET)
	public List<MyClass2> list (Model model) 
	{
		MyClass2Criteria myClass2Criteria = new MyClass2Criteria();
		model.addAttribute(myClass2Criteria);
		return this.myClass2Service.findAll();	
	}

	@RequestMapping(value = "/myclass2/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass2> search (@ModelAttribute MyClass2Criteria criteria) 
	{
		return this.myClass2Service.findByCriteria(criteria);	
	}


}
