package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass39Service;
import java.util.List;
import big.domain.MyClass39;
import big.repositories.criteria.MyClass39Criteria;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass39.class)
public class MyClass39SearchController
{

	
	@Autowired
	private MyClass39Service myClass39Service;
    

	@RequestMapping(value = "/myclass39/list", method = RequestMethod.GET)
	public List<MyClass39> list (Model model) 
	{
		MyClass39Criteria myClass39Criteria = new MyClass39Criteria();
		model.addAttribute(myClass39Criteria);
		return this.myClass39Service.findAll();	
	}

	@RequestMapping(value = "/myclass39/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass39> search (@ModelAttribute MyClass39Criteria criteria) 
	{
		return this.myClass39Service.findByCriteria(criteria);	
	}


}
