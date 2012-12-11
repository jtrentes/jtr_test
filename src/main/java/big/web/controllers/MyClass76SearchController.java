package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass76Criteria;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass89;
import big.services.MyClass89Service;
import big.domain.MyClass76;
import big.services.MyClass76Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass76.class)
public class MyClass76SearchController
{

	
	@Autowired
	private MyClass76Service myClass76Service;
	
	@Autowired
	private MyClass89Service myClass89Service;
    

	@ModelAttribute(value = "myclass89s")
	public List<MyClass89> getMyClass89s () 
	{
		return this.myClass89Service.findAll();	
	}

	@RequestMapping(value = "/myclass76/list", method = RequestMethod.GET)
	public List<MyClass76> list (Model model) 
	{
		MyClass76Criteria myClass76Criteria = new MyClass76Criteria();
		model.addAttribute(myClass76Criteria);
		return this.myClass76Service.findAll();	
	}

	@RequestMapping(value = "/myclass76/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass76> search (@ModelAttribute MyClass76Criteria criteria) 
	{
		return this.myClass76Service.findByCriteria(criteria);	
	}


}
