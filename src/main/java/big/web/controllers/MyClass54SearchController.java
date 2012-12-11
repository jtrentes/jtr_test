package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass54Criteria;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass54;
import big.services.MyClass54Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass54.class)
public class MyClass54SearchController
{

	
	@Autowired
	private MyClass54Service myClass54Service;
    

	@RequestMapping(value = "/myclass54/list", method = RequestMethod.GET)
	public List<MyClass54> list (Model model) 
	{
		MyClass54Criteria myClass54Criteria = new MyClass54Criteria();
		model.addAttribute(myClass54Criteria);
		return this.myClass54Service.findAll();	
	}

	@RequestMapping(value = "/myclass54/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass54> search (@ModelAttribute MyClass54Criteria criteria) 
	{
		return this.myClass54Service.findByCriteria(criteria);	
	}


}
