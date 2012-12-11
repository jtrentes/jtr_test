package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.services.MyClass72Service;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass72Criteria;
import big.domain.MyClass72;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass72.class)
public class MyClass72SearchController
{

	
	@Autowired
	private MyClass72Service myClass72Service;
    

	@RequestMapping(value = "/myclass72/list", method = RequestMethod.GET)
	public List<MyClass72> list (Model model) 
	{
		MyClass72Criteria myClass72Criteria = new MyClass72Criteria();
		model.addAttribute(myClass72Criteria);
		return this.myClass72Service.findAll();	
	}

	@RequestMapping(value = "/myclass72/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass72> search (@ModelAttribute MyClass72Criteria criteria) 
	{
		return this.myClass72Service.findByCriteria(criteria);	
	}


}
