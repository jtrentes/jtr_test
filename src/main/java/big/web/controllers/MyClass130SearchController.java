package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass130;
import big.repositories.criteria.MyClass130Criteria;
import java.util.List;
import big.services.MyClass130Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass130.class)
public class MyClass130SearchController
{

	
	@Autowired
	private MyClass130Service myClass130Service;
    

	@RequestMapping(value = "/myclass130/list", method = RequestMethod.GET)
	public List<MyClass130> list (Model model) 
	{
		MyClass130Criteria myClass130Criteria = new MyClass130Criteria();
		model.addAttribute(myClass130Criteria);
		return this.myClass130Service.findAll();	
	}

	@RequestMapping(value = "/myclass130/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass130> search (@ModelAttribute MyClass130Criteria criteria) 
	{
		return this.myClass130Service.findByCriteria(criteria);	
	}


}
