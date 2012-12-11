package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass160Service;
import java.util.List;
import big.domain.MyClass160;
import big.repositories.criteria.MyClass160Criteria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass160.class)
public class MyClass160SearchController
{

	
	@Autowired
	private MyClass160Service myClass160Service;
    

	@RequestMapping(value = "/myclass160/list", method = RequestMethod.GET)
	public List<MyClass160> list (Model model) 
	{
		MyClass160Criteria myClass160Criteria = new MyClass160Criteria();
		model.addAttribute(myClass160Criteria);
		return this.myClass160Service.findAll();	
	}

	@RequestMapping(value = "/myclass160/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass160> search (@ModelAttribute MyClass160Criteria criteria) 
	{
		return this.myClass160Service.findByCriteria(criteria);	
	}


}
