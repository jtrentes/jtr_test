package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.services.MyClass114Service;
import org.springframework.ui.Model;
import big.domain.MyClass114;
import big.repositories.criteria.MyClass114Criteria;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass114.class)
public class MyClass114SearchController
{

	
	@Autowired
	private MyClass114Service myClass114Service;
    

	@RequestMapping(value = "/myclass114/list", method = RequestMethod.GET)
	public List<MyClass114> list (Model model) 
	{
		MyClass114Criteria myClass114Criteria = new MyClass114Criteria();
		model.addAttribute(myClass114Criteria);
		return this.myClass114Service.findAll();	
	}

	@RequestMapping(value = "/myclass114/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass114> search (@ModelAttribute MyClass114Criteria criteria) 
	{
		return this.myClass114Service.findByCriteria(criteria);	
	}


}
