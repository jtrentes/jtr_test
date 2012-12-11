package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass132Service;
import big.domain.MyClass132;
import java.util.List;
import big.repositories.criteria.MyClass132Criteria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass132.class)
public class MyClass132SearchController
{

	
	@Autowired
	private MyClass132Service myClass132Service;
    

	@RequestMapping(value = "/myclass132/list", method = RequestMethod.GET)
	public List<MyClass132> list (Model model) 
	{
		MyClass132Criteria myClass132Criteria = new MyClass132Criteria();
		model.addAttribute(myClass132Criteria);
		return this.myClass132Service.findAll();	
	}

	@RequestMapping(value = "/myclass132/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass132> search (@ModelAttribute MyClass132Criteria criteria) 
	{
		return this.myClass132Service.findByCriteria(criteria);	
	}


}
