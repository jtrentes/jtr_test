package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass11Criteria;
import big.domain.MyClass11;
import java.util.List;
import big.services.MyClass11Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass11.class)
public class MyClass11SearchController
{

	
	@Autowired
	private MyClass11Service myClass11Service;
    

	@RequestMapping(value = "/myclass11/list", method = RequestMethod.GET)
	public List<MyClass11> list (Model model) 
	{
		MyClass11Criteria myClass11Criteria = new MyClass11Criteria();
		model.addAttribute(myClass11Criteria);
		return this.myClass11Service.findAll();	
	}

	@RequestMapping(value = "/myclass11/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass11> search (@ModelAttribute MyClass11Criteria criteria) 
	{
		return this.myClass11Service.findByCriteria(criteria);	
	}


}
