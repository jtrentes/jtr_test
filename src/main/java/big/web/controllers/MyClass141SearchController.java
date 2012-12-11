package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.services.MyClass141Service;
import big.domain.MyClass141;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass141Criteria;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass141.class)
public class MyClass141SearchController
{

	
	@Autowired
	private MyClass141Service myClass141Service;
    

	@RequestMapping(value = "/myclass141/list", method = RequestMethod.GET)
	public List<MyClass141> list (Model model) 
	{
		MyClass141Criteria myClass141Criteria = new MyClass141Criteria();
		model.addAttribute(myClass141Criteria);
		return this.myClass141Service.findAll();	
	}

	@RequestMapping(value = "/myclass141/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass141> search (@ModelAttribute MyClass141Criteria criteria) 
	{
		return this.myClass141Service.findByCriteria(criteria);	
	}


}
