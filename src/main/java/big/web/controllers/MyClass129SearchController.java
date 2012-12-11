package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass129Service;
import big.domain.MyClass129;
import big.repositories.criteria.MyClass129Criteria;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass129.class)
public class MyClass129SearchController
{

	
	@Autowired
	private MyClass129Service myClass129Service;
    

	@RequestMapping(value = "/myclass129/list", method = RequestMethod.GET)
	public List<MyClass129> list (Model model) 
	{
		MyClass129Criteria myClass129Criteria = new MyClass129Criteria();
		model.addAttribute(myClass129Criteria);
		return this.myClass129Service.findAll();	
	}

	@RequestMapping(value = "/myclass129/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass129> search (@ModelAttribute MyClass129Criteria criteria) 
	{
		return this.myClass129Service.findByCriteria(criteria);	
	}


}
