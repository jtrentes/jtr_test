package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass57Service;
import big.repositories.criteria.MyClass25Criteria;
import org.springframework.ui.Model;
import java.util.List;
import big.services.MyClass25Service;
import big.domain.MyClass57;
import big.domain.MyClass25;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass25.class)
public class MyClass25SearchController
{

	
	@Autowired
	private MyClass25Service myClass25Service;
	
	@Autowired
	private MyClass57Service myClass57Service;
    

	@ModelAttribute(value = "myclass57s")
	public List<MyClass57> getMyClass57s () 
	{
		return this.myClass57Service.findAll();	
	}

	@RequestMapping(value = "/myclass25/list", method = RequestMethod.GET)
	public List<MyClass25> list (Model model) 
	{
		MyClass25Criteria myClass25Criteria = new MyClass25Criteria();
		model.addAttribute(myClass25Criteria);
		return this.myClass25Service.findAll();	
	}

	@RequestMapping(value = "/myclass25/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass25> search (@ModelAttribute MyClass25Criteria criteria) 
	{
		return this.myClass25Service.findByCriteria(criteria);	
	}


}
