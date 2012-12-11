package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass159;
import big.repositories.criteria.MyClass159Criteria;
import big.services.MyClass159Service;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass159.class)
public class MyClass159SearchController
{

	
	@Autowired
	private MyClass159Service myClass159Service;
    

	@RequestMapping(value = "/myclass159/list", method = RequestMethod.GET)
	public List<MyClass159> list (Model model) 
	{
		MyClass159Criteria myClass159Criteria = new MyClass159Criteria();
		model.addAttribute(myClass159Criteria);
		return this.myClass159Service.findAll();	
	}

	@RequestMapping(value = "/myclass159/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass159> search (@ModelAttribute MyClass159Criteria criteria) 
	{
		return this.myClass159Service.findByCriteria(criteria);	
	}


}
