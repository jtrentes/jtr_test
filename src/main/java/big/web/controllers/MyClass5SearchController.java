package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass5Criteria;
import org.springframework.ui.Model;
import big.services.MyClass9Service;
import big.domain.MyClass9;
import java.util.List;
import big.services.MyClass5Service;
import big.domain.MyClass5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass5.class)
public class MyClass5SearchController
{

	
	@Autowired
	private MyClass5Service myClass5Service;
	
	@Autowired
	private MyClass9Service myClass9Service;
    

	@ModelAttribute(value = "myclass9s")
	public List<MyClass9> getMyClass9s () 
	{
		return this.myClass9Service.findAll();	
	}

	@RequestMapping(value = "/myclass5/list", method = RequestMethod.GET)
	public List<MyClass5> list (Model model) 
	{
		MyClass5Criteria myClass5Criteria = new MyClass5Criteria();
		model.addAttribute(myClass5Criteria);
		return this.myClass5Service.findAll();	
	}

	@RequestMapping(value = "/myclass5/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass5> search (@ModelAttribute MyClass5Criteria criteria) 
	{
		return this.myClass5Service.findByCriteria(criteria);	
	}


}
