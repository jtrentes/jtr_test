package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass16Criteria;
import big.domain.MyClass16;
import java.util.List;
import big.services.MyClass16Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass16.class)
public class MyClass16SearchController
{

	
	@Autowired
	private MyClass16Service myClass16Service;
    

	@RequestMapping(value = "/myclass16/list", method = RequestMethod.GET)
	public List<MyClass16> list (Model model) 
	{
		MyClass16Criteria myClass16Criteria = new MyClass16Criteria();
		model.addAttribute(myClass16Criteria);
		return this.myClass16Service.findAll();	
	}

	@RequestMapping(value = "/myclass16/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass16> search (@ModelAttribute MyClass16Criteria criteria) 
	{
		return this.myClass16Service.findByCriteria(criteria);	
	}


}
