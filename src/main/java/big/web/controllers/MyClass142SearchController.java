package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass142;
import big.repositories.criteria.MyClass142Criteria;
import java.util.List;
import big.services.MyClass142Service;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass142.class)
public class MyClass142SearchController
{

	
	@Autowired
	private MyClass142Service myClass142Service;
    

	@RequestMapping(value = "/myclass142/list", method = RequestMethod.GET)
	public List<MyClass142> list (Model model) 
	{
		MyClass142Criteria myClass142Criteria = new MyClass142Criteria();
		model.addAttribute(myClass142Criteria);
		return this.myClass142Service.findAll();	
	}

	@RequestMapping(value = "/myclass142/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass142> search (@ModelAttribute MyClass142Criteria criteria) 
	{
		return this.myClass142Service.findByCriteria(criteria);	
	}


}
