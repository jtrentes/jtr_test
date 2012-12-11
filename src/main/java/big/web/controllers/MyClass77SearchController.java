package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.domain.MyClass77;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass77Criteria;
import big.services.MyClass77Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass77.class)
public class MyClass77SearchController
{

	
	@Autowired
	private MyClass77Service myClass77Service;
    

	@RequestMapping(value = "/myclass77/list", method = RequestMethod.GET)
	public List<MyClass77> list (Model model) 
	{
		MyClass77Criteria myClass77Criteria = new MyClass77Criteria();
		model.addAttribute(myClass77Criteria);
		return this.myClass77Service.findAll();	
	}

	@RequestMapping(value = "/myclass77/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass77> search (@ModelAttribute MyClass77Criteria criteria) 
	{
		return this.myClass77Service.findByCriteria(criteria);	
	}


}
