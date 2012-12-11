package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass143Service;
import big.repositories.criteria.MyClass143Criteria;
import big.domain.MyClass143;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass143.class)
public class MyClass143SearchController
{

	
	@Autowired
	private MyClass143Service myClass143Service;
    

	@RequestMapping(value = "/myclass143/list", method = RequestMethod.GET)
	public List<MyClass143> list (Model model) 
	{
		MyClass143Criteria myClass143Criteria = new MyClass143Criteria();
		model.addAttribute(myClass143Criteria);
		return this.myClass143Service.findAll();	
	}

	@RequestMapping(value = "/myclass143/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass143> search (@ModelAttribute MyClass143Criteria criteria) 
	{
		return this.myClass143Service.findByCriteria(criteria);	
	}


}
