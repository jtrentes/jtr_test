package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass102;
import big.domain.MyClass111;
import big.services.MyClass102Service;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass102Criteria;
import java.util.List;
import big.services.MyClass111Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass102.class)
public class MyClass102SearchController
{

	
	@Autowired
	private MyClass102Service myClass102Service;
	
	@Autowired
	private MyClass111Service myClass111Service;
    

	@ModelAttribute(value = "myclass111s")
	public List<MyClass111> getMyClass111s () 
	{
		return this.myClass111Service.findAll();	
	}

	@RequestMapping(value = "/myclass102/list", method = RequestMethod.GET)
	public List<MyClass102> list (Model model) 
	{
		MyClass102Criteria myClass102Criteria = new MyClass102Criteria();
		model.addAttribute(myClass102Criteria);
		return this.myClass102Service.findAll();	
	}

	@RequestMapping(value = "/myclass102/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass102> search (@ModelAttribute MyClass102Criteria criteria) 
	{
		return this.myClass102Service.findByCriteria(criteria);	
	}


}
