package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass70;
import big.repositories.criteria.MyClass70Criteria;
import java.util.List;
import big.services.MyClass70Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass70.class)
public class MyClass70SearchController
{

	
	@Autowired
	private MyClass70Service myClass70Service;
    

	@RequestMapping(value = "/myclass70/list", method = RequestMethod.GET)
	public List<MyClass70> list (Model model) 
	{
		MyClass70Criteria myClass70Criteria = new MyClass70Criteria();
		model.addAttribute(myClass70Criteria);
		return this.myClass70Service.findAll();	
	}

	@RequestMapping(value = "/myclass70/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass70> search (@ModelAttribute MyClass70Criteria criteria) 
	{
		return this.myClass70Service.findByCriteria(criteria);	
	}


}
