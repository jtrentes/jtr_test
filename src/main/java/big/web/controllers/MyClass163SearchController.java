package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass163Service;
import java.util.List;
import big.repositories.criteria.MyClass163Criteria;
import big.services.MyClass28Service;
import big.domain.MyClass163;
import org.springframework.ui.Model;
import big.domain.MyClass28;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass163.class)
public class MyClass163SearchController
{

	
	@Autowired
	private MyClass163Service myClass163Service;
	
	@Autowired
	private MyClass28Service myClass28Service;
    

	@ModelAttribute(value = "myclass28s")
	public List<MyClass28> getMyClass28s () 
	{
		return this.myClass28Service.findAll();	
	}

	@RequestMapping(value = "/myclass163/list", method = RequestMethod.GET)
	public List<MyClass163> list (Model model) 
	{
		MyClass163Criteria myClass163Criteria = new MyClass163Criteria();
		model.addAttribute(myClass163Criteria);
		return this.myClass163Service.findAll();	
	}

	@RequestMapping(value = "/myclass163/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass163> search (@ModelAttribute MyClass163Criteria criteria) 
	{
		return this.myClass163Service.findByCriteria(criteria);	
	}


}
