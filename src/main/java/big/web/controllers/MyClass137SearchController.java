package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass137Service;
import java.util.List;
import big.domain.MyClass137;
import big.repositories.criteria.MyClass137Criteria;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass137.class)
public class MyClass137SearchController
{

	
	@Autowired
	private MyClass137Service myClass137Service;
    

	@RequestMapping(value = "/myclass137/list", method = RequestMethod.GET)
	public List<MyClass137> list (Model model) 
	{
		MyClass137Criteria myClass137Criteria = new MyClass137Criteria();
		model.addAttribute(myClass137Criteria);
		return this.myClass137Service.findAll();	
	}

	@RequestMapping(value = "/myclass137/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass137> search (@ModelAttribute MyClass137Criteria criteria) 
	{
		return this.myClass137Service.findByCriteria(criteria);	
	}


}
