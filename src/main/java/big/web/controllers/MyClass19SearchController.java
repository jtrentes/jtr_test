package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass19;
import big.services.MyClass19Service;
import org.springframework.ui.Model;
import java.util.List;
import big.repositories.criteria.MyClass19Criteria;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass19.class)
public class MyClass19SearchController
{

	
	@Autowired
	private MyClass19Service myClass19Service;
    

	@RequestMapping(value = "/myclass19/list", method = RequestMethod.GET)
	public List<MyClass19> list (Model model) 
	{
		MyClass19Criteria myClass19Criteria = new MyClass19Criteria();
		model.addAttribute(myClass19Criteria);
		return this.myClass19Service.findAll();	
	}

	@RequestMapping(value = "/myclass19/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass19> search (@ModelAttribute MyClass19Criteria criteria) 
	{
		return this.myClass19Service.findByCriteria(criteria);	
	}


}
