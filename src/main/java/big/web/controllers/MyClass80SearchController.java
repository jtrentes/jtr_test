package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import java.util.List;
import big.services.MyClass80Service;
import big.domain.MyClass80;
import big.repositories.criteria.MyClass80Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass80.class)
public class MyClass80SearchController
{

	
	@Autowired
	private MyClass80Service myClass80Service;
    

	@RequestMapping(value = "/myclass80/list", method = RequestMethod.GET)
	public List<MyClass80> list (Model model) 
	{
		MyClass80Criteria myClass80Criteria = new MyClass80Criteria();
		model.addAttribute(myClass80Criteria);
		return this.myClass80Service.findAll();	
	}

	@RequestMapping(value = "/myclass80/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass80> search (@ModelAttribute MyClass80Criteria criteria) 
	{
		return this.myClass80Service.findByCriteria(criteria);	
	}


}
