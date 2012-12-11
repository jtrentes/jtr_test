package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass150;
import big.repositories.criteria.MyClass150Criteria;
import org.springframework.ui.Model;
import big.services.MyClass150Service;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass150.class)
public class MyClass150SearchController
{

	
	@Autowired
	private MyClass150Service myClass150Service;
    

	@RequestMapping(value = "/myclass150/list", method = RequestMethod.GET)
	public List<MyClass150> list (Model model) 
	{
		MyClass150Criteria myClass150Criteria = new MyClass150Criteria();
		model.addAttribute(myClass150Criteria);
		return this.myClass150Service.findAll();	
	}

	@RequestMapping(value = "/myclass150/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass150> search (@ModelAttribute MyClass150Criteria criteria) 
	{
		return this.myClass150Service.findByCriteria(criteria);	
	}


}
