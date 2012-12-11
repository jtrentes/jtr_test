package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass14Criteria;
import java.util.List;
import big.services.MyClass14Service;
import org.springframework.ui.Model;
import big.domain.MyClass14;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass14.class)
public class MyClass14SearchController
{

	
	@Autowired
	private MyClass14Service myClass14Service;
    

	@RequestMapping(value = "/myclass14/list", method = RequestMethod.GET)
	public List<MyClass14> list (Model model) 
	{
		MyClass14Criteria myClass14Criteria = new MyClass14Criteria();
		model.addAttribute(myClass14Criteria);
		return this.myClass14Service.findAll();	
	}

	@RequestMapping(value = "/myclass14/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass14> search (@ModelAttribute MyClass14Criteria criteria) 
	{
		return this.myClass14Service.findByCriteria(criteria);	
	}


}
