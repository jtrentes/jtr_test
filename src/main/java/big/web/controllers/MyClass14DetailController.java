package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass14Validator;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass14Service;
import org.springframework.ui.Model;
import big.domain.MyClass14;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass14.class)
public class MyClass14DetailController
{

	
	@Autowired
	private MyClass14Service myClass14Service;
    

	@RequestMapping(value = "/myclass14/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass14/edit";	
	}

	@RequestMapping(value = "/myclass14/detail/{myClass14Id}")
	public String details (@PathVariable(value = "myClass14Id") Long myClass14Id, Model model) 
	{
		MyClass14 myClass14 = this.myClass14Service.findById(myClass14Id);
		model.addAttribute(myClass14);
		return "myclass14/detail";	
	}

	@RequestMapping(value = "/myclass14/edit/{myClass14Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass14Id") Long myClass14Id, Model model) 
	{
		MyClass14 myClass14 = this.myClass14Service.findById(myClass14Id);
		model.addAttribute(myClass14);
		return "myclass14/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass14Validator());	
	}

	@RequestMapping(value = "/myclass14/edit", method = RequestMethod.GET)
	public MyClass14 newMyClass14 (Model model) 
	{
		if(model != null && model.asMap().get("myclass14") == null)
		{
			return new MyClass14();	
		}
		return (MyClass14) model.asMap().get("myclass14");	
	}

	@RequestMapping(value = {"/myclass14/edit", "/myclass14/edit/{myclass14Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass14 MyClass14, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass14/edit";
		}
		
		
		
		this.myClass14Service.save(MyClass14);
		session.setComplete();
		return "redirect:/myclass14/list";	
	}


}
