package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass118Criteria;
import big.domain.MyClass118;
import java.util.List;
import org.springframework.ui.Model;
import big.services.MyClass118Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass118.class)
public class MyClass118SearchController
{

	
	@Autowired
	private MyClass118Service myClass118Service;
    

	@RequestMapping(value = "/myclass118/list", method = RequestMethod.GET)
	public List<MyClass118> list (Model model) 
	{
		MyClass118Criteria myClass118Criteria = new MyClass118Criteria();
		model.addAttribute(myClass118Criteria);
		return this.myClass118Service.findAll();	
	}

	@RequestMapping(value = "/myclass118/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass118> search (@ModelAttribute MyClass118Criteria criteria) 
	{
		return this.myClass118Service.findByCriteria(criteria);	
	}


}
