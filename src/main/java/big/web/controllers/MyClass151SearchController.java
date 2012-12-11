package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass151Criteria;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass151;
import big.services.MyClass151Service;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass151.class)
public class MyClass151SearchController
{

	
	@Autowired
	private MyClass151Service myClass151Service;
    

	@RequestMapping(value = "/myclass151/list", method = RequestMethod.GET)
	public List<MyClass151> list (Model model) 
	{
		MyClass151Criteria myClass151Criteria = new MyClass151Criteria();
		model.addAttribute(myClass151Criteria);
		return this.myClass151Service.findAll();	
	}

	@RequestMapping(value = "/myclass151/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass151> search (@ModelAttribute MyClass151Criteria criteria) 
	{
		return this.myClass151Service.findByCriteria(criteria);	
	}


}
