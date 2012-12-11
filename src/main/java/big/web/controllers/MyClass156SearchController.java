package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.domain.MyClass156;
import big.services.MyClass156Service;
import big.repositories.criteria.MyClass156Criteria;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass156.class)
public class MyClass156SearchController
{

	
	@Autowired
	private MyClass156Service myClass156Service;
    

	@RequestMapping(value = "/myclass156/list", method = RequestMethod.GET)
	public List<MyClass156> list (Model model) 
	{
		MyClass156Criteria myClass156Criteria = new MyClass156Criteria();
		model.addAttribute(myClass156Criteria);
		return this.myClass156Service.findAll();	
	}

	@RequestMapping(value = "/myclass156/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass156> search (@ModelAttribute MyClass156Criteria criteria) 
	{
		return this.myClass156Service.findByCriteria(criteria);	
	}


}
