package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass41Criteria;
import big.services.MyClass41Service;
import big.domain.MyClass41;
import java.util.List;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass41.class)
public class MyClass41SearchController
{

	
	@Autowired
	private MyClass41Service myClass41Service;
    

	@RequestMapping(value = "/myclass41/list", method = RequestMethod.GET)
	public List<MyClass41> list (Model model) 
	{
		MyClass41Criteria myClass41Criteria = new MyClass41Criteria();
		model.addAttribute(myClass41Criteria);
		return this.myClass41Service.findAll();	
	}

	@RequestMapping(value = "/myclass41/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass41> search (@ModelAttribute MyClass41Criteria criteria) 
	{
		return this.myClass41Service.findByCriteria(criteria);	
	}


}
