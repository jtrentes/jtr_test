package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass139Criteria;
import java.util.List;
import big.domain.MyClass139;
import big.services.MyClass139Service;
import org.springframework.ui.Model;
import big.domain.MyClass131;
import big.services.MyClass131Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass139.class)
public class MyClass139SearchController
{

	
	@Autowired
	private MyClass131Service myClass131Service;
	
	@Autowired
	private MyClass139Service myClass139Service;
    

	@ModelAttribute(value = "myclass131s")
	public List<MyClass131> getMyClass131s () 
	{
		return this.myClass131Service.findAll();	
	}

	@RequestMapping(value = "/myclass139/list", method = RequestMethod.GET)
	public List<MyClass139> list (Model model) 
	{
		MyClass139Criteria myClass139Criteria = new MyClass139Criteria();
		model.addAttribute(myClass139Criteria);
		return this.myClass139Service.findAll();	
	}

	@RequestMapping(value = "/myclass139/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass139> search (@ModelAttribute MyClass139Criteria criteria) 
	{
		return this.myClass139Service.findByCriteria(criteria);	
	}


}
