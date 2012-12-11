package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass110Service;
import big.repositories.criteria.MyClass110Criteria;
import big.domain.MyClass110;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass110.class)
public class MyClass110SearchController
{

	
	@Autowired
	private MyClass110Service myClass110Service;
    

	@RequestMapping(value = "/myclass110/list", method = RequestMethod.GET)
	public List<MyClass110> list (Model model) 
	{
		MyClass110Criteria myClass110Criteria = new MyClass110Criteria();
		model.addAttribute(myClass110Criteria);
		return this.myClass110Service.findAll();	
	}

	@RequestMapping(value = "/myclass110/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass110> search (@ModelAttribute MyClass110Criteria criteria) 
	{
		return this.myClass110Service.findByCriteria(criteria);	
	}


}
