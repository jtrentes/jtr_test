package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass121;
import java.util.List;
import big.services.MyClass121Service;
import big.repositories.criteria.MyClass121Criteria;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass121.class)
public class MyClass121SearchController
{

	
	@Autowired
	private MyClass121Service myClass121Service;
    

	@RequestMapping(value = "/myclass121/list", method = RequestMethod.GET)
	public List<MyClass121> list (Model model) 
	{
		MyClass121Criteria myClass121Criteria = new MyClass121Criteria();
		model.addAttribute(myClass121Criteria);
		return this.myClass121Service.findAll();	
	}

	@RequestMapping(value = "/myclass121/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass121> search (@ModelAttribute MyClass121Criteria criteria) 
	{
		return this.myClass121Service.findByCriteria(criteria);	
	}


}
