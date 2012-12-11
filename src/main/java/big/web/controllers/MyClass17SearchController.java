package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass17Service;
import java.util.List;
import big.domain.MyClass17;
import big.services.MyClass76Service;
import big.domain.MyClass76;
import big.repositories.criteria.MyClass17Criteria;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass17.class)
public class MyClass17SearchController
{

	
	@Autowired
	private MyClass17Service myClass17Service;
	
	@Autowired
	private MyClass76Service myClass76Service;
    

	@ModelAttribute(value = "myclass76s")
	public List<MyClass76> getMyClass76s () 
	{
		return this.myClass76Service.findAll();	
	}

	@RequestMapping(value = "/myclass17/list", method = RequestMethod.GET)
	public List<MyClass17> list (Model model) 
	{
		MyClass17Criteria myClass17Criteria = new MyClass17Criteria();
		model.addAttribute(myClass17Criteria);
		return this.myClass17Service.findAll();	
	}

	@RequestMapping(value = "/myclass17/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass17> search (@ModelAttribute MyClass17Criteria criteria) 
	{
		return this.myClass17Service.findByCriteria(criteria);	
	}


}
