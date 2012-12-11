package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass20Service;
import org.springframework.ui.Model;
import big.domain.MyClass20;
import java.util.List;
import big.repositories.criteria.MyClass20Criteria;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass20.class)
public class MyClass20SearchController
{

	
	@Autowired
	private MyClass20Service myClass20Service;
    

	@RequestMapping(value = "/myclass20/list", method = RequestMethod.GET)
	public List<MyClass20> list (Model model) 
	{
		MyClass20Criteria myClass20Criteria = new MyClass20Criteria();
		model.addAttribute(myClass20Criteria);
		return this.myClass20Service.findAll();	
	}

	@RequestMapping(value = "/myclass20/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass20> search (@ModelAttribute MyClass20Criteria criteria) 
	{
		return this.myClass20Service.findByCriteria(criteria);	
	}


}
