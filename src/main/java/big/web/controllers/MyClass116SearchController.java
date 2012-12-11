package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import java.util.List;
import big.repositories.criteria.MyClass116Criteria;
import big.domain.MyClass116;
import big.services.MyClass116Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass116.class)
public class MyClass116SearchController
{

	
	@Autowired
	private MyClass116Service myClass116Service;
    

	@RequestMapping(value = "/myclass116/list", method = RequestMethod.GET)
	public List<MyClass116> list (Model model) 
	{
		MyClass116Criteria myClass116Criteria = new MyClass116Criteria();
		model.addAttribute(myClass116Criteria);
		return this.myClass116Service.findAll();	
	}

	@RequestMapping(value = "/myclass116/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass116> search (@ModelAttribute MyClass116Criteria criteria) 
	{
		return this.myClass116Service.findByCriteria(criteria);	
	}


}
