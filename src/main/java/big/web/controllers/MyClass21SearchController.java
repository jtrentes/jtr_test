package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass21;
import big.services.MyClass21Service;
import big.repositories.criteria.MyClass21Criteria;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass21.class)
public class MyClass21SearchController
{

	
	@Autowired
	private MyClass21Service myClass21Service;
    

	@RequestMapping(value = "/myclass21/list", method = RequestMethod.GET)
	public List<MyClass21> list (Model model) 
	{
		MyClass21Criteria myClass21Criteria = new MyClass21Criteria();
		model.addAttribute(myClass21Criteria);
		return this.myClass21Service.findAll();	
	}

	@RequestMapping(value = "/myclass21/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass21> search (@ModelAttribute MyClass21Criteria criteria) 
	{
		return this.myClass21Service.findByCriteria(criteria);	
	}


}
