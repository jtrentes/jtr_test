package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass101Service;
import java.util.List;
import big.repositories.criteria.MyClass101Criteria;
import big.domain.MyClass101;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass101.class)
public class MyClass101SearchController
{

	
	@Autowired
	private MyClass101Service myClass101Service;
    

	@RequestMapping(value = "/myclass101/list", method = RequestMethod.GET)
	public List<MyClass101> list (Model model) 
	{
		MyClass101Criteria myClass101Criteria = new MyClass101Criteria();
		model.addAttribute(myClass101Criteria);
		return this.myClass101Service.findAll();	
	}

	@RequestMapping(value = "/myclass101/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass101> search (@ModelAttribute MyClass101Criteria criteria) 
	{
		return this.myClass101Service.findByCriteria(criteria);	
	}


}
