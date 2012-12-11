package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass138Criteria;
import java.util.List;
import big.services.MyClass138Service;
import big.domain.MyClass138;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass138.class)
public class MyClass138SearchController
{

	
	@Autowired
	private MyClass138Service myClass138Service;
    

	@RequestMapping(value = "/myclass138/list", method = RequestMethod.GET)
	public List<MyClass138> list (Model model) 
	{
		MyClass138Criteria myClass138Criteria = new MyClass138Criteria();
		model.addAttribute(myClass138Criteria);
		return this.myClass138Service.findAll();	
	}

	@RequestMapping(value = "/myclass138/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass138> search (@ModelAttribute MyClass138Criteria criteria) 
	{
		return this.myClass138Service.findByCriteria(criteria);	
	}


}
