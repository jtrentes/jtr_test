package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.domain.MyClass161;
import big.services.MyClass161Service;
import big.repositories.criteria.MyClass161Criteria;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass161.class)
public class MyClass161SearchController
{

	
	@Autowired
	private MyClass161Service myClass161Service;
    

	@RequestMapping(value = "/myclass161/list", method = RequestMethod.GET)
	public List<MyClass161> list (Model model) 
	{
		MyClass161Criteria myClass161Criteria = new MyClass161Criteria();
		model.addAttribute(myClass161Criteria);
		return this.myClass161Service.findAll();	
	}

	@RequestMapping(value = "/myclass161/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass161> search (@ModelAttribute MyClass161Criteria criteria) 
	{
		return this.myClass161Service.findByCriteria(criteria);	
	}


}
