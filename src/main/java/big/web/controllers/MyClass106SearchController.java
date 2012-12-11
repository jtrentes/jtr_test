package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.ui.Model;
import big.services.MyClass106Service;
import big.domain.MyClass106;
import big.repositories.criteria.MyClass106Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass106.class)
public class MyClass106SearchController
{

	
	@Autowired
	private MyClass106Service myClass106Service;
    

	@RequestMapping(value = "/myclass106/list", method = RequestMethod.GET)
	public List<MyClass106> list (Model model) 
	{
		MyClass106Criteria myClass106Criteria = new MyClass106Criteria();
		model.addAttribute(myClass106Criteria);
		return this.myClass106Service.findAll();	
	}

	@RequestMapping(value = "/myclass106/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass106> search (@ModelAttribute MyClass106Criteria criteria) 
	{
		return this.myClass106Service.findByCriteria(criteria);	
	}


}
