package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass112Service;
import org.springframework.ui.Model;
import java.util.List;
import big.domain.MyClass112;
import big.repositories.criteria.MyClass112Criteria;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass112.class)
public class MyClass112SearchController
{

	
	@Autowired
	private MyClass112Service myClass112Service;
    

	@RequestMapping(value = "/myclass112/list", method = RequestMethod.GET)
	public List<MyClass112> list (Model model) 
	{
		MyClass112Criteria myClass112Criteria = new MyClass112Criteria();
		model.addAttribute(myClass112Criteria);
		return this.myClass112Service.findAll();	
	}

	@RequestMapping(value = "/myclass112/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass112> search (@ModelAttribute MyClass112Criteria criteria) 
	{
		return this.myClass112Service.findByCriteria(criteria);	
	}


}
