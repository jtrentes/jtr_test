package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass54Service;
import big.services.MyClass45Service;
import big.domain.MyClass45;
import org.springframework.ui.Model;
import big.repositories.criteria.MyClass45Criteria;
import big.domain.MyClass54;
import big.services.MyClass46Service;
import java.util.List;
import big.domain.MyClass46;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass45.class)
public class MyClass45SearchController
{

	
	@Autowired
	private MyClass45Service myClass45Service;
	
	@Autowired
	private MyClass46Service myClass46Service;
	
	@Autowired
	private MyClass54Service myClass54Service;
    

	@ModelAttribute(value = "myclass46s")
	public List<MyClass46> getMyClass46s () 
	{
		return this.myClass46Service.findAll();	
	}

	@ModelAttribute(value = "myclass54s")
	public List<MyClass54> getMyClass54s () 
	{
		return this.myClass54Service.findAll();	
	}

	@RequestMapping(value = "/myclass45/list", method = RequestMethod.GET)
	public List<MyClass45> list (Model model) 
	{
		MyClass45Criteria myClass45Criteria = new MyClass45Criteria();
		model.addAttribute(myClass45Criteria);
		return this.myClass45Service.findAll();	
	}

	@RequestMapping(value = "/myclass45/list", method = {RequestMethod.POST, RequestMethod.PUT})
	public List<MyClass45> search (@ModelAttribute MyClass45Criteria criteria) 
	{
		return this.myClass45Service.findByCriteria(criteria);	
	}


}
