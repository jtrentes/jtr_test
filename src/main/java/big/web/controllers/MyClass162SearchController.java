package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.services.MyClass162Service;
import big.repositories.criteria.MyClass162Criteria;
import org.springframework.ui.Model;
import big.domain.MyClass162;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass162.class)
public class MyClass162SearchController
{

	
	@Autowired
	private MyClass162Service myClass162Service;
    

	@RequestMapping(value = "/myclass162/list", method = RequestMethod.GET)
	public List<MyClass162> list (Model model) 
	{
		MyClass162Criteria myClass162Criteria = new MyClass162Criteria();
		model.addAttribute(myClass162Criteria);
		return this.myClass162Service.findAll();	
	}

	@RequestMapping(value = "/myclass162/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass162> search (@ModelAttribute MyClass162Criteria criteria) 
	{
		return this.myClass162Service.findByCriteria(criteria);	
	}


}
