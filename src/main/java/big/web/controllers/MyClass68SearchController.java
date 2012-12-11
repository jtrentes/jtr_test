package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.ui.Model;
import big.services.MyClass68Service;
import big.domain.MyClass68;
import big.repositories.criteria.MyClass68Criteria;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass68.class)
public class MyClass68SearchController
{

	
	@Autowired
	private MyClass68Service myClass68Service;
    

	@RequestMapping(value = "/myclass68/list", method = RequestMethod.GET)
	public List<MyClass68> list (Model model) 
	{
		MyClass68Criteria myClass68Criteria = new MyClass68Criteria();
		model.addAttribute(myClass68Criteria);
		return this.myClass68Service.findAll();	
	}

	@RequestMapping(value = "/myclass68/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass68> search (@ModelAttribute MyClass68Criteria criteria) 
	{
		return this.myClass68Service.findByCriteria(criteria);	
	}


}
