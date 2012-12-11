package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass49Service;
import big.repositories.criteria.MyClass49Criteria;
import org.springframework.ui.Model;
import big.domain.MyClass49;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass49.class)
public class MyClass49SearchController
{

	
	@Autowired
	private MyClass49Service myClass49Service;
    

	@RequestMapping(value = "/myclass49/list", method = RequestMethod.GET)
	public List<MyClass49> list (Model model) 
	{
		MyClass49Criteria myClass49Criteria = new MyClass49Criteria();
		model.addAttribute(myClass49Criteria);
		return this.myClass49Service.findAll();	
	}

	@RequestMapping(value = "/myclass49/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass49> search (@ModelAttribute MyClass49Criteria criteria) 
	{
		return this.myClass49Service.findByCriteria(criteria);	
	}


}
