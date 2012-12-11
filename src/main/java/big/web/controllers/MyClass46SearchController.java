package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass30Service;
import big.domain.MyClass46;
import big.repositories.criteria.MyClass46Criteria;
import org.springframework.ui.Model;
import big.domain.MyClass30;
import big.services.MyClass46Service;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass46.class)
public class MyClass46SearchController
{

	
	@Autowired
	private MyClass30Service myClass30Service;
	
	@Autowired
	private MyClass46Service myClass46Service;
    

	@ModelAttribute(value = "myclass30s")
	public List<MyClass30> getMyClass30s () 
	{
		return this.myClass30Service.findAll();	
	}

	@RequestMapping(value = "/myclass46/list", method = RequestMethod.GET)
	public List<MyClass46> list (Model model) 
	{
		MyClass46Criteria myClass46Criteria = new MyClass46Criteria();
		model.addAttribute(myClass46Criteria);
		return this.myClass46Service.findAll();	
	}

	@RequestMapping(value = "/myclass46/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass46> search (@ModelAttribute MyClass46Criteria criteria) 
	{
		return this.myClass46Service.findByCriteria(criteria);	
	}


}
