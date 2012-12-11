package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass85;
import big.repositories.criteria.MyClass85Criteria;
import big.services.MyClass85Service;
import java.util.List;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass85.class)
public class MyClass85SearchController
{

	
	@Autowired
	private MyClass85Service myClass85Service;
    

	@RequestMapping(value = "/myclass85/list", method = RequestMethod.GET)
	public List<MyClass85> list (Model model) 
	{
		MyClass85Criteria myClass85Criteria = new MyClass85Criteria();
		model.addAttribute(myClass85Criteria);
		return this.myClass85Service.findAll();	
	}

	@RequestMapping(value = "/myclass85/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass85> search (@ModelAttribute MyClass85Criteria criteria) 
	{
		return this.myClass85Service.findByCriteria(criteria);	
	}


}
