package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.domain.MyClass88;
import big.services.MyClass88Service;
import big.repositories.criteria.MyClass88Criteria;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass88.class)
public class MyClass88SearchController
{

	
	@Autowired
	private MyClass88Service myClass88Service;
    

	@RequestMapping(value = "/myclass88/list", method = RequestMethod.GET)
	public List<MyClass88> list (Model model) 
	{
		MyClass88Criteria myClass88Criteria = new MyClass88Criteria();
		model.addAttribute(myClass88Criteria);
		return this.myClass88Service.findAll();	
	}

	@RequestMapping(value = "/myclass88/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass88> search (@ModelAttribute MyClass88Criteria criteria) 
	{
		return this.myClass88Service.findByCriteria(criteria);	
	}


}
