package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass71Service;
import java.util.List;
import big.domain.MyClass71;
import big.domain.MyClass78;
import big.repositories.criteria.MyClass71Criteria;
import big.services.MyClass78Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass71.class)
public class MyClass71SearchController
{

	
	@Autowired
	private MyClass71Service myClass71Service;
	
	@Autowired
	private MyClass78Service myClass78Service;
    

	@ModelAttribute(value = "myclass78s")
	public List<MyClass78> getMyClass78s () 
	{
		return this.myClass78Service.findAll();	
	}

	@RequestMapping(value = "/myclass71/list", method = RequestMethod.GET)
	public List<MyClass71> list (Model model) 
	{
		MyClass71Criteria myClass71Criteria = new MyClass71Criteria();
		model.addAttribute(myClass71Criteria);
		return this.myClass71Service.findAll();	
	}

	@RequestMapping(value = "/myclass71/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass71> search (@ModelAttribute MyClass71Criteria criteria) 
	{
		return this.myClass71Service.findByCriteria(criteria);	
	}


}
