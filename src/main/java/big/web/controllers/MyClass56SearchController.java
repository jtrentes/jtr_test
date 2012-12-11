package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass56Service;
import big.domain.MyClass56;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass56Criteria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass56.class)
public class MyClass56SearchController
{

	
	@Autowired
	private MyClass56Service myClass56Service;
    

	@RequestMapping(value = "/myclass56/list", method = RequestMethod.GET)
	public List<MyClass56> list (Model model) 
	{
		MyClass56Criteria myClass56Criteria = new MyClass56Criteria();
		model.addAttribute(myClass56Criteria);
		return this.myClass56Service.findAll();	
	}

	@RequestMapping(value = "/myclass56/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass56> search (@ModelAttribute MyClass56Criteria criteria) 
	{
		return this.myClass56Service.findByCriteria(criteria);	
	}


}
