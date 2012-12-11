package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass126Service;
import big.repositories.criteria.MyClass126Criteria;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass126;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass126.class)
public class MyClass126SearchController
{

	
	@Autowired
	private MyClass126Service myClass126Service;
    

	@RequestMapping(value = "/myclass126/list", method = RequestMethod.GET)
	public List<MyClass126> list (Model model) 
	{
		MyClass126Criteria myClass126Criteria = new MyClass126Criteria();
		model.addAttribute(myClass126Criteria);
		return this.myClass126Service.findAll();	
	}

	@RequestMapping(value = "/myclass126/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass126> search (@ModelAttribute MyClass126Criteria criteria) 
	{
		return this.myClass126Service.findByCriteria(criteria);	
	}


}
