package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass131Criteria;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass120;
import big.services.MyClass131Service;
import big.domain.MyClass131;
import big.services.MyClass120Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass131.class)
public class MyClass131SearchController
{

	
	@Autowired
	private MyClass120Service myClass120Service;
	
	@Autowired
	private MyClass131Service myClass131Service;
    

	@ModelAttribute(value = "myclass120s")
	public List<MyClass120> getMyClass120s () 
	{
		return this.myClass120Service.findAll();	
	}

	@RequestMapping(value = "/myclass131/list", method = RequestMethod.GET)
	public List<MyClass131> list (Model model) 
	{
		MyClass131Criteria myClass131Criteria = new MyClass131Criteria();
		model.addAttribute(myClass131Criteria);
		return this.myClass131Service.findAll();	
	}

	@RequestMapping(value = "/myclass131/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass131> search (@ModelAttribute MyClass131Criteria criteria) 
	{
		return this.myClass131Service.findByCriteria(criteria);	
	}


}
