package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass109;
import big.services.MyClass109Service;
import big.repositories.criteria.MyClass109Criteria;
import java.util.List;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass109.class)
public class MyClass109SearchController
{

	
	@Autowired
	private MyClass109Service myClass109Service;
    

	@RequestMapping(value = "/myclass109/list", method = RequestMethod.GET)
	public List<MyClass109> list (Model model) 
	{
		MyClass109Criteria myClass109Criteria = new MyClass109Criteria();
		model.addAttribute(myClass109Criteria);
		return this.myClass109Service.findAll();	
	}

	@RequestMapping(value = "/myclass109/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass109> search (@ModelAttribute MyClass109Criteria criteria) 
	{
		return this.myClass109Service.findByCriteria(criteria);	
	}


}
