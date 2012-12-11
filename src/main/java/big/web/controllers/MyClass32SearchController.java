package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass32Service;
import big.domain.MyClass32;
import big.services.MyClass62Service;
import java.util.List;
import big.domain.MyClass62;
import big.repositories.criteria.MyClass32Criteria;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass32.class)
public class MyClass32SearchController
{

	
	@Autowired
	private MyClass32Service myClass32Service;
	
	@Autowired
	private MyClass62Service myClass62Service;
    

	@ModelAttribute(value = "myclass62s")
	public List<MyClass62> getMyClass62s () 
	{
		return this.myClass62Service.findAll();	
	}

	@RequestMapping(value = "/myclass32/list", method = RequestMethod.GET)
	public List<MyClass32> list (Model model) 
	{
		MyClass32Criteria myClass32Criteria = new MyClass32Criteria();
		model.addAttribute(myClass32Criteria);
		return this.myClass32Service.findAll();	
	}

	@RequestMapping(value = "/myclass32/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass32> search (@ModelAttribute MyClass32Criteria criteria) 
	{
		return this.myClass32Service.findByCriteria(criteria);	
	}


}
