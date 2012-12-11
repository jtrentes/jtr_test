package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass12Criteria;
import java.util.List;
import big.services.MyClass12Service;
import big.domain.MyClass12;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass12.class)
public class MyClass12SearchController
{

	
	@Autowired
	private MyClass12Service myClass12Service;
    

	@RequestMapping(value = "/myclass12/list", method = RequestMethod.GET)
	public List<MyClass12> list (Model model) 
	{
		MyClass12Criteria myClass12Criteria = new MyClass12Criteria();
		model.addAttribute(myClass12Criteria);
		return this.myClass12Service.findAll();	
	}

	@RequestMapping(value = "/myclass12/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass12> search (@ModelAttribute MyClass12Criteria criteria) 
	{
		return this.myClass12Service.findByCriteria(criteria);	
	}


}
