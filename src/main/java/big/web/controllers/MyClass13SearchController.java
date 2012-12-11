package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass13Service;
import java.util.List;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass13Criteria;
import big.domain.MyClass13;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass13.class)
public class MyClass13SearchController
{

	
	@Autowired
	private MyClass13Service myClass13Service;
    

	@RequestMapping(value = "/myclass13/list", method = RequestMethod.GET)
	public List<MyClass13> list (Model model) 
	{
		MyClass13Criteria myClass13Criteria = new MyClass13Criteria();
		model.addAttribute(myClass13Criteria);
		return this.myClass13Service.findAll();	
	}

	@RequestMapping(value = "/myclass13/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass13> search (@ModelAttribute MyClass13Criteria criteria) 
	{
		return this.myClass13Service.findByCriteria(criteria);	
	}


}
