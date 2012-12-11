package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass2;
import big.services.MyClass2Service;
import big.repositories.criteria.MyClass3Criteria;
import big.domain.MyClass3;
import org.springframework.ui.Model;
import big.services.MyClass3Service;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass3.class)
public class MyClass3SearchController
{

	
	@Autowired
	private MyClass2Service myClass2Service;
	
	@Autowired
	private MyClass3Service myClass3Service;
    

	@ModelAttribute(value = "myclass2s")
	public List<MyClass2> getMyClass2s () 
	{
		return this.myClass2Service.findAll();	
	}

	@RequestMapping(value = "/myclass3/list", method = RequestMethod.GET)
	public List<MyClass3> list (Model model) 
	{
		MyClass3Criteria myClass3Criteria = new MyClass3Criteria();
		model.addAttribute(myClass3Criteria);
		return this.myClass3Service.findAll();	
	}

	@RequestMapping(value = "/myclass3/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass3> search (@ModelAttribute MyClass3Criteria criteria) 
	{
		return this.myClass3Service.findByCriteria(criteria);	
	}


}
