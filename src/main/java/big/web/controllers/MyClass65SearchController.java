package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.repositories.criteria.MyClass65Criteria;
import big.domain.MyClass65;
import org.springframework.ui.Model;
import big.services.MyClass65Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass65.class)
public class MyClass65SearchController
{

	
	@Autowired
	private MyClass65Service myClass65Service;
    

	@RequestMapping(value = "/myclass65/list", method = RequestMethod.GET)
	public List<MyClass65> list (Model model) 
	{
		MyClass65Criteria myClass65Criteria = new MyClass65Criteria();
		model.addAttribute(myClass65Criteria);
		return this.myClass65Service.findAll();	
	}

	@RequestMapping(value = "/myclass65/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass65> search (@ModelAttribute MyClass65Criteria criteria) 
	{
		return this.myClass65Service.findByCriteria(criteria);	
	}


}
