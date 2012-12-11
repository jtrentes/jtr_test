package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass94Service;
import big.domain.MyClass94;
import big.repositories.criteria.MyClass94Criteria;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass94.class)
public class MyClass94SearchController
{

	
	@Autowired
	private MyClass94Service myClass94Service;
    

	@RequestMapping(value = "/myclass94/list", method = RequestMethod.GET)
	public List<MyClass94> list (Model model) 
	{
		MyClass94Criteria myClass94Criteria = new MyClass94Criteria();
		model.addAttribute(myClass94Criteria);
		return this.myClass94Service.findAll();	
	}

	@RequestMapping(value = "/myclass94/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass94> search (@ModelAttribute MyClass94Criteria criteria) 
	{
		return this.myClass94Service.findByCriteria(criteria);	
	}


}
