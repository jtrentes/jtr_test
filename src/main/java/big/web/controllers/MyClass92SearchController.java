package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass92;
import big.services.MyClass92Service;
import big.repositories.criteria.MyClass92Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass92.class)
public class MyClass92SearchController
{

	
	@Autowired
	private MyClass92Service myClass92Service;
    

	@RequestMapping(value = "/myclass92/list", method = RequestMethod.GET)
	public List<MyClass92> list (Model model) 
	{
		MyClass92Criteria myClass92Criteria = new MyClass92Criteria();
		model.addAttribute(myClass92Criteria);
		return this.myClass92Service.findAll();	
	}

	@RequestMapping(value = "/myclass92/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass92> search (@ModelAttribute MyClass92Criteria criteria) 
	{
		return this.myClass92Service.findByCriteria(criteria);	
	}


}
