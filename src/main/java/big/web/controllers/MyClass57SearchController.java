package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass57Criteria;
import org.springframework.ui.Model;
import java.util.List;
import big.domain.MyClass37;
import big.services.MyClass57Service;
import big.services.MyClass37Service;
import big.domain.MyClass57;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass57.class)
public class MyClass57SearchController
{

	
	@Autowired
	private MyClass37Service myClass37Service;
	
	@Autowired
	private MyClass57Service myClass57Service;
    

	@ModelAttribute(value = "myclass37s")
	public List<MyClass37> getMyClass37s () 
	{
		return this.myClass37Service.findAll();	
	}

	@RequestMapping(value = "/myclass57/list", method = RequestMethod.GET)
	public List<MyClass57> list (Model model) 
	{
		MyClass57Criteria myClass57Criteria = new MyClass57Criteria();
		model.addAttribute(myClass57Criteria);
		return this.myClass57Service.findAll();	
	}

	@RequestMapping(value = "/myclass57/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass57> search (@ModelAttribute MyClass57Criteria criteria) 
	{
		return this.myClass57Service.findByCriteria(criteria);	
	}


}
