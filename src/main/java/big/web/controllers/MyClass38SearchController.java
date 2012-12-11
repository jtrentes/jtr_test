package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.repositories.criteria.MyClass38Criteria;
import big.services.MyClass38Service;
import big.domain.MyClass38;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass38.class)
public class MyClass38SearchController
{

	
	@Autowired
	private MyClass38Service myClass38Service;
    

	@RequestMapping(value = "/myclass38/list", method = RequestMethod.GET)
	public List<MyClass38> list (Model model) 
	{
		MyClass38Criteria myClass38Criteria = new MyClass38Criteria();
		model.addAttribute(myClass38Criteria);
		return this.myClass38Service.findAll();	
	}

	@RequestMapping(value = "/myclass38/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass38> search (@ModelAttribute MyClass38Criteria criteria) 
	{
		return this.myClass38Service.findByCriteria(criteria);	
	}


}
