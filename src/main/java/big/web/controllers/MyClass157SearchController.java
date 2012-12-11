package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass157;
import org.springframework.ui.Model;
import big.services.MyClass157Service;
import java.util.List;
import big.repositories.criteria.MyClass157Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass157.class)
public class MyClass157SearchController
{

	
	@Autowired
	private MyClass157Service myClass157Service;
    

	@RequestMapping(value = "/myclass157/list", method = RequestMethod.GET)
	public List<MyClass157> list (Model model) 
	{
		MyClass157Criteria myClass157Criteria = new MyClass157Criteria();
		model.addAttribute(myClass157Criteria);
		return this.myClass157Service.findAll();	
	}

	@RequestMapping(value = "/myclass157/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass157> search (@ModelAttribute MyClass157Criteria criteria) 
	{
		return this.myClass157Service.findByCriteria(criteria);	
	}


}
