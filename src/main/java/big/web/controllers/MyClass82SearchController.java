package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass82Service;
import org.springframework.ui.Model;
import java.util.List;
import big.domain.MyClass82;
import big.repositories.criteria.MyClass82Criteria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass82.class)
public class MyClass82SearchController
{

	
	@Autowired
	private MyClass82Service myClass82Service;
    

	@RequestMapping(value = "/myclass82/list", method = RequestMethod.GET)
	public List<MyClass82> list (Model model) 
	{
		MyClass82Criteria myClass82Criteria = new MyClass82Criteria();
		model.addAttribute(myClass82Criteria);
		return this.myClass82Service.findAll();	
	}

	@RequestMapping(value = "/myclass82/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass82> search (@ModelAttribute MyClass82Criteria criteria) 
	{
		return this.myClass82Service.findByCriteria(criteria);	
	}


}
