package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import java.util.List;
import big.repositories.criteria.MyClass128Criteria;
import big.domain.MyClass128;
import big.services.MyClass128Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass128.class)
public class MyClass128SearchController
{

	
	@Autowired
	private MyClass128Service myClass128Service;
    

	@RequestMapping(value = "/myclass128/list", method = RequestMethod.GET)
	public List<MyClass128> list (Model model) 
	{
		MyClass128Criteria myClass128Criteria = new MyClass128Criteria();
		model.addAttribute(myClass128Criteria);
		return this.myClass128Service.findAll();	
	}

	@RequestMapping(value = "/myclass128/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass128> search (@ModelAttribute MyClass128Criteria criteria) 
	{
		return this.myClass128Service.findByCriteria(criteria);	
	}


}
