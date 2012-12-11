package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass58Service;
import java.util.List;
import big.services.MyClass131Service;
import big.repositories.criteria.MyClass58Criteria;
import big.domain.MyClass131;
import big.domain.MyClass58;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass58.class)
public class MyClass58SearchController
{

	
	@Autowired
	private MyClass131Service myClass131Service;
	
	@Autowired
	private MyClass58Service myClass58Service;
    

	@ModelAttribute(value = "myclass131s")
	public List<MyClass131> getMyClass131s () 
	{
		return this.myClass131Service.findAll();	
	}

	@RequestMapping(value = "/myclass58/list", method = RequestMethod.GET)
	public List<MyClass58> list (Model model) 
	{
		MyClass58Criteria myClass58Criteria = new MyClass58Criteria();
		model.addAttribute(myClass58Criteria);
		return this.myClass58Service.findAll();	
	}

	@RequestMapping(value = "/myclass58/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass58> search (@ModelAttribute MyClass58Criteria criteria) 
	{
		return this.myClass58Service.findByCriteria(criteria);	
	}


}
