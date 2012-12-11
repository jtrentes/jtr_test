package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass154Criteria;
import org.springframework.ui.Model;
import big.services.MyClass154Service;
import big.domain.MyClass154;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass154.class)
public class MyClass154SearchController
{

	
	@Autowired
	private MyClass154Service myClass154Service;
    

	@RequestMapping(value = "/myclass154/list", method = RequestMethod.GET)
	public List<MyClass154> list (Model model) 
	{
		MyClass154Criteria myClass154Criteria = new MyClass154Criteria();
		model.addAttribute(myClass154Criteria);
		return this.myClass154Service.findAll();	
	}

	@RequestMapping(value = "/myclass154/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass154> search (@ModelAttribute MyClass154Criteria criteria) 
	{
		return this.myClass154Service.findByCriteria(criteria);	
	}


}
