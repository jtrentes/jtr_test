package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass153Criteria;
import big.services.MyClass153Service;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass153;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass153.class)
public class MyClass153SearchController
{

	
	@Autowired
	private MyClass153Service myClass153Service;
    

	@RequestMapping(value = "/myclass153/list", method = RequestMethod.GET)
	public List<MyClass153> list (Model model) 
	{
		MyClass153Criteria myClass153Criteria = new MyClass153Criteria();
		model.addAttribute(myClass153Criteria);
		return this.myClass153Service.findAll();	
	}

	@RequestMapping(value = "/myclass153/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass153> search (@ModelAttribute MyClass153Criteria criteria) 
	{
		return this.myClass153Service.findByCriteria(criteria);	
	}


}
