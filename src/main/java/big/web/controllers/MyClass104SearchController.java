package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import java.util.List;
import big.domain.MyClass104;
import big.services.MyClass104Service;
import big.repositories.criteria.MyClass104Criteria;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass104.class)
public class MyClass104SearchController
{

	
	@Autowired
	private MyClass104Service myClass104Service;
    

	@RequestMapping(value = "/myclass104/list", method = RequestMethod.GET)
	public List<MyClass104> list (Model model) 
	{
		MyClass104Criteria myClass104Criteria = new MyClass104Criteria();
		model.addAttribute(myClass104Criteria);
		return this.myClass104Service.findAll();	
	}

	@RequestMapping(value = "/myclass104/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass104> search (@ModelAttribute MyClass104Criteria criteria) 
	{
		return this.myClass104Service.findByCriteria(criteria);	
	}


}
