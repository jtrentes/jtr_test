package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass105Criteria;
import java.util.List;
import big.services.MyClass105Service;
import org.springframework.ui.Model;
import big.domain.MyClass105;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass105.class)
public class MyClass105SearchController
{

	
	@Autowired
	private MyClass105Service myClass105Service;
    

	@RequestMapping(value = "/myclass105/list", method = RequestMethod.GET)
	public List<MyClass105> list (Model model) 
	{
		MyClass105Criteria myClass105Criteria = new MyClass105Criteria();
		model.addAttribute(myClass105Criteria);
		return this.myClass105Service.findAll();	
	}

	@RequestMapping(value = "/myclass105/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass105> search (@ModelAttribute MyClass105Criteria criteria) 
	{
		return this.myClass105Service.findByCriteria(criteria);	
	}


}
