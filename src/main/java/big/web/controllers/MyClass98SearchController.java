package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.services.MyClass98Service;
import org.springframework.ui.Model;
import big.domain.MyClass98;
import big.repositories.criteria.MyClass98Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass98.class)
public class MyClass98SearchController
{

	
	@Autowired
	private MyClass98Service myClass98Service;
    

	@RequestMapping(value = "/myclass98/list", method = RequestMethod.GET)
	public List<MyClass98> list (Model model) 
	{
		MyClass98Criteria myClass98Criteria = new MyClass98Criteria();
		model.addAttribute(myClass98Criteria);
		return this.myClass98Service.findAll();	
	}

	@RequestMapping(value = "/myclass98/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass98> search (@ModelAttribute MyClass98Criteria criteria) 
	{
		return this.myClass98Service.findByCriteria(criteria);	
	}


}
