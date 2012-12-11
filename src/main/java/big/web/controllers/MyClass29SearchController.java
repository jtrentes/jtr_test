package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass29Service;
import big.repositories.criteria.MyClass29Criteria;
import java.util.List;
import big.domain.MyClass29;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass29.class)
public class MyClass29SearchController
{

	
	@Autowired
	private MyClass29Service myClass29Service;
    

	@RequestMapping(value = "/myclass29/list", method = RequestMethod.GET)
	public List<MyClass29> list (Model model) 
	{
		MyClass29Criteria myClass29Criteria = new MyClass29Criteria();
		model.addAttribute(myClass29Criteria);
		return this.myClass29Service.findAll();	
	}

	@RequestMapping(value = "/myclass29/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass29> search (@ModelAttribute MyClass29Criteria criteria) 
	{
		return this.myClass29Service.findByCriteria(criteria);	
	}


}
