package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.domain.MyClass64;
import big.repositories.criteria.MyClass64Criteria;
import org.springframework.ui.Model;
import big.services.MyClass64Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass64.class)
public class MyClass64SearchController
{

	
	@Autowired
	private MyClass64Service myClass64Service;
    

	@RequestMapping(value = "/myclass64/list", method = RequestMethod.GET)
	public List<MyClass64> list (Model model) 
	{
		MyClass64Criteria myClass64Criteria = new MyClass64Criteria();
		model.addAttribute(myClass64Criteria);
		return this.myClass64Service.findAll();	
	}

	@RequestMapping(value = "/myclass64/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass64> search (@ModelAttribute MyClass64Criteria criteria) 
	{
		return this.myClass64Service.findByCriteria(criteria);	
	}


}
