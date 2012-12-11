package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass103;
import big.repositories.criteria.MyClass103Criteria;
import java.util.List;
import big.services.MyClass103Service;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass103.class)
public class MyClass103SearchController
{

	
	@Autowired
	private MyClass103Service myClass103Service;
    

	@RequestMapping(value = "/myclass103/list", method = RequestMethod.GET)
	public List<MyClass103> list (Model model) 
	{
		MyClass103Criteria myClass103Criteria = new MyClass103Criteria();
		model.addAttribute(myClass103Criteria);
		return this.myClass103Service.findAll();	
	}

	@RequestMapping(value = "/myclass103/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass103> search (@ModelAttribute MyClass103Criteria criteria) 
	{
		return this.myClass103Service.findByCriteria(criteria);	
	}


}
