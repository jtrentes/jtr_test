package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import java.util.List;
import big.repositories.criteria.MyClass33Criteria;
import big.services.MyClass33Service;
import big.domain.MyClass33;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass33.class)
public class MyClass33SearchController
{

	
	@Autowired
	private MyClass33Service myClass33Service;
    

	@RequestMapping(value = "/myclass33/list", method = RequestMethod.GET)
	public List<MyClass33> list (Model model) 
	{
		MyClass33Criteria myClass33Criteria = new MyClass33Criteria();
		model.addAttribute(myClass33Criteria);
		return this.myClass33Service.findAll();	
	}

	@RequestMapping(value = "/myclass33/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass33> search (@ModelAttribute MyClass33Criteria criteria) 
	{
		return this.myClass33Service.findByCriteria(criteria);	
	}


}
