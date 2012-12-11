package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass6Service;
import java.util.List;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass6Criteria;
import big.services.MyClass12Service;
import big.domain.MyClass6;
import big.domain.MyClass12;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass6.class)
public class MyClass6SearchController
{

	
	@Autowired
	private MyClass12Service myClass12Service;
	
	@Autowired
	private MyClass6Service myClass6Service;
    

	@ModelAttribute(value = "myclass12s")
	public List<MyClass12> getMyClass12s () 
	{
		return this.myClass12Service.findAll();	
	}

	@RequestMapping(value = "/myclass6/list", method = RequestMethod.GET)
	public List<MyClass6> list (Model model) 
	{
		MyClass6Criteria myClass6Criteria = new MyClass6Criteria();
		model.addAttribute(myClass6Criteria);
		return this.myClass6Service.findAll();	
	}

	@RequestMapping(value = "/myclass6/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass6> search (@ModelAttribute MyClass6Criteria criteria) 
	{
		return this.myClass6Service.findByCriteria(criteria);	
	}


}
