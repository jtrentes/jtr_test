package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.repositories.criteria.MyClass52Criteria;
import big.services.MyClass52Service;
import big.domain.MyClass52;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass52.class)
public class MyClass52SearchController
{

	
	@Autowired
	private MyClass52Service myClass52Service;
    

	@RequestMapping(value = "/myclass52/list", method = RequestMethod.GET)
	public List<MyClass52> list (Model model) 
	{
		MyClass52Criteria myClass52Criteria = new MyClass52Criteria();
		model.addAttribute(myClass52Criteria);
		return this.myClass52Service.findAll();	
	}

	@RequestMapping(value = "/myclass52/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass52> search (@ModelAttribute MyClass52Criteria criteria) 
	{
		return this.myClass52Service.findByCriteria(criteria);	
	}


}
