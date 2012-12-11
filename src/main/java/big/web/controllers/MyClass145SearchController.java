package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.repositories.criteria.MyClass145Criteria;
import big.services.MyClass145Service;
import org.springframework.ui.Model;
import java.util.List;
import big.domain.MyClass145;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass145.class)
public class MyClass145SearchController
{

	
	@Autowired
	private MyClass145Service myClass145Service;
    

	@RequestMapping(value = "/myclass145/list", method = RequestMethod.GET)
	public List<MyClass145> list (Model model) 
	{
		MyClass145Criteria myClass145Criteria = new MyClass145Criteria();
		model.addAttribute(myClass145Criteria);
		return this.myClass145Service.findAll();	
	}

	@RequestMapping(value = "/myclass145/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass145> search (@ModelAttribute MyClass145Criteria criteria) 
	{
		return this.myClass145Service.findByCriteria(criteria);	
	}


}
