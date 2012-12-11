package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass86;
import big.services.MyClass86Service;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass86Criteria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass86.class)
public class MyClass86SearchController
{

	
	@Autowired
	private MyClass86Service myClass86Service;
    

	@RequestMapping(value = "/myclass86/list", method = RequestMethod.GET)
	public List<MyClass86> list (Model model) 
	{
		MyClass86Criteria myClass86Criteria = new MyClass86Criteria();
		model.addAttribute(myClass86Criteria);
		return this.myClass86Service.findAll();	
	}

	@RequestMapping(value = "/myclass86/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass86> search (@ModelAttribute MyClass86Criteria criteria) 
	{
		return this.myClass86Service.findByCriteria(criteria);	
	}


}
