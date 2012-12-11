package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass93;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass93Criteria;
import big.services.MyClass93Service;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass93.class)
public class MyClass93SearchController
{

	
	@Autowired
	private MyClass93Service myClass93Service;
    

	@RequestMapping(value = "/myclass93/list", method = RequestMethod.GET)
	public List<MyClass93> list (Model model) 
	{
		MyClass93Criteria myClass93Criteria = new MyClass93Criteria();
		model.addAttribute(myClass93Criteria);
		return this.myClass93Service.findAll();	
	}

	@RequestMapping(value = "/myclass93/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass93> search (@ModelAttribute MyClass93Criteria criteria) 
	{
		return this.myClass93Service.findByCriteria(criteria);	
	}


}
