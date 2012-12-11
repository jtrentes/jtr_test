package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass54Service;
import java.util.List;
import big.domain.MyClass54;
import big.repositories.criteria.MyClass37Criteria;
import org.springframework.ui.Model;
import big.services.MyClass37Service;
import big.domain.MyClass37;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass37.class)
public class MyClass37SearchController
{

	
	@Autowired
	private MyClass37Service myClass37Service;
	
	@Autowired
	private MyClass54Service myClass54Service;
    

	@ModelAttribute(value = "myclass54s")
	public List<MyClass54> getMyClass54s () 
	{
		return this.myClass54Service.findAll();	
	}

	@RequestMapping(value = "/myclass37/list", method = RequestMethod.GET)
	public List<MyClass37> list (Model model) 
	{
		MyClass37Criteria myClass37Criteria = new MyClass37Criteria();
		model.addAttribute(myClass37Criteria);
		return this.myClass37Service.findAll();	
	}

	@RequestMapping(value = "/myclass37/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass37> search (@ModelAttribute MyClass37Criteria criteria) 
	{
		return this.myClass37Service.findByCriteria(criteria);	
	}


}
