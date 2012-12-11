package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass10Service;
import big.domain.MyClass10;
import java.util.List;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass10Criteria;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass10.class)
public class MyClass10SearchController
{

	
	@Autowired
	private MyClass10Service myClass10Service;
    

	@RequestMapping(value = "/myclass10/list", method = RequestMethod.GET)
	public List<MyClass10> list (Model model) 
	{
		MyClass10Criteria myClass10Criteria = new MyClass10Criteria();
		model.addAttribute(myClass10Criteria);
		return this.myClass10Service.findAll();	
	}

	@RequestMapping(value = "/myclass10/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass10> search (@ModelAttribute MyClass10Criteria criteria) 
	{
		return this.myClass10Service.findByCriteria(criteria);	
	}


}
