package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass153Service;
import org.springframework.ui.Model;
import big.services.MyClass18Service;
import big.repositories.criteria.MyClass18Criteria;
import big.domain.MyClass18;
import java.util.List;
import big.domain.MyClass153;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass18.class)
public class MyClass18SearchController
{

	
	@Autowired
	private MyClass153Service myClass153Service;
	
	@Autowired
	private MyClass18Service myClass18Service;
    

	@ModelAttribute(value = "myclass153s")
	public List<MyClass153> getMyClass153s () 
	{
		return this.myClass153Service.findAll();	
	}

	@RequestMapping(value = "/myclass18/list", method = RequestMethod.GET)
	public List<MyClass18> list (Model model) 
	{
		MyClass18Criteria myClass18Criteria = new MyClass18Criteria();
		model.addAttribute(myClass18Criteria);
		return this.myClass18Service.findAll();	
	}

	@RequestMapping(value = "/myclass18/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass18> search (@ModelAttribute MyClass18Criteria criteria) 
	{
		return this.myClass18Service.findByCriteria(criteria);	
	}


}
