package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass133;
import big.domain.MyClass5;
import big.services.MyClass5Service;
import java.util.List;
import big.repositories.criteria.MyClass133Criteria;
import org.springframework.ui.Model;
import big.services.MyClass133Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass133.class)
public class MyClass133SearchController
{

	
	@Autowired
	private MyClass133Service myClass133Service;
	
	@Autowired
	private MyClass5Service myClass5Service;
    

	@ModelAttribute(value = "myclass5s")
	public List<MyClass5> getMyClass5s () 
	{
		return this.myClass5Service.findAll();	
	}

	@RequestMapping(value = "/myclass133/list", method = RequestMethod.GET)
	public List<MyClass133> list (Model model) 
	{
		MyClass133Criteria myClass133Criteria = new MyClass133Criteria();
		model.addAttribute(myClass133Criteria);
		return this.myClass133Service.findAll();	
	}

	@RequestMapping(value = "/myclass133/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass133> search (@ModelAttribute MyClass133Criteria criteria) 
	{
		return this.myClass133Service.findByCriteria(criteria);	
	}


}
