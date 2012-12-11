package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.ui.Model;
import big.services.MyClass36Service;
import big.repositories.criteria.MyClass36Criteria;
import big.domain.MyClass36;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass36.class)
public class MyClass36SearchController
{

	
	@Autowired
	private MyClass36Service myClass36Service;
    

	@RequestMapping(value = "/myclass36/list", method = RequestMethod.GET)
	public List<MyClass36> list (Model model) 
	{
		MyClass36Criteria myClass36Criteria = new MyClass36Criteria();
		model.addAttribute(myClass36Criteria);
		return this.myClass36Service.findAll();	
	}

	@RequestMapping(value = "/myclass36/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass36> search (@ModelAttribute MyClass36Criteria criteria) 
	{
		return this.myClass36Service.findByCriteria(criteria);	
	}


}
