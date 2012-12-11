package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass89Criteria;
import org.springframework.ui.Model;
import big.services.MyClass124Service;
import big.services.MyClass89Service;
import java.util.List;
import big.domain.MyClass89;
import big.domain.MyClass124;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass89.class)
public class MyClass89SearchController
{

	
	@Autowired
	private MyClass124Service myClass124Service;
	
	@Autowired
	private MyClass89Service myClass89Service;
    

	@ModelAttribute(value = "myclass124s")
	public List<MyClass124> getMyClass124s () 
	{
		return this.myClass124Service.findAll();	
	}

	@RequestMapping(value = "/myclass89/list", method = RequestMethod.GET)
	public List<MyClass89> list (Model model) 
	{
		MyClass89Criteria myClass89Criteria = new MyClass89Criteria();
		model.addAttribute(myClass89Criteria);
		return this.myClass89Service.findAll();	
	}

	@RequestMapping(value = "/myclass89/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass89> search (@ModelAttribute MyClass89Criteria criteria) 
	{
		return this.myClass89Service.findByCriteria(criteria);	
	}


}
