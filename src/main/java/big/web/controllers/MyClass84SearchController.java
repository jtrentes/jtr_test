package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass84Service;
import org.springframework.ui.Model;
import java.util.List;
import big.domain.MyClass84;
import big.repositories.criteria.MyClass84Criteria;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass84.class)
public class MyClass84SearchController
{

	
	@Autowired
	private MyClass84Service myClass84Service;
    

	@RequestMapping(value = "/myclass84/list", method = RequestMethod.GET)
	public List<MyClass84> list (Model model) 
	{
		MyClass84Criteria myClass84Criteria = new MyClass84Criteria();
		model.addAttribute(myClass84Criteria);
		return this.myClass84Service.findAll();	
	}

	@RequestMapping(value = "/myclass84/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass84> search (@ModelAttribute MyClass84Criteria criteria) 
	{
		return this.myClass84Service.findByCriteria(criteria);	
	}


}
