package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass112Service;
import big.services.MyClass107Service;
import java.util.List;
import big.domain.MyClass112;
import big.repositories.criteria.MyClass107Criteria;
import big.domain.MyClass107;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass107.class)
public class MyClass107SearchController
{

	
	@Autowired
	private MyClass107Service myClass107Service;
	
	@Autowired
	private MyClass112Service myClass112Service;
    

	@ModelAttribute(value = "myclass112s")
	public List<MyClass112> getMyClass112s () 
	{
		return this.myClass112Service.findAll();	
	}

	@RequestMapping(value = "/myclass107/list", method = RequestMethod.GET)
	public List<MyClass107> list (Model model) 
	{
		MyClass107Criteria myClass107Criteria = new MyClass107Criteria();
		model.addAttribute(myClass107Criteria);
		return this.myClass107Service.findAll();	
	}

	@RequestMapping(value = "/myclass107/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass107> search (@ModelAttribute MyClass107Criteria criteria) 
	{
		return this.myClass107Service.findByCriteria(criteria);	
	}


}
