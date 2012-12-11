package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass31Validator;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass31Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.domain.MyClass31;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass31.class)
public class MyClass31DetailController
{

	
	@Autowired
	private MyClass31Service myClass31Service;
    

	@RequestMapping(value = "/myclass31/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass31/edit";	
	}

	@RequestMapping(value = "/myclass31/detail/{myClass31Id}")
	public String details (@PathVariable(value = "myClass31Id") Long myClass31Id, Model model) 
	{
		MyClass31 myClass31 = this.myClass31Service.findById(myClass31Id);
		model.addAttribute(myClass31);
		return "myclass31/detail";	
	}

	@RequestMapping(value = "/myclass31/edit/{myClass31Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass31Id") Long myClass31Id, Model model) 
	{
		MyClass31 myClass31 = this.myClass31Service.findById(myClass31Id);
		model.addAttribute(myClass31);
		return "myclass31/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass31Validator());	
	}

	@RequestMapping(value = "/myclass31/edit", method = RequestMethod.GET)
	public MyClass31 newMyClass31 (Model model) 
	{
		if(model != null && model.asMap().get("myclass31") == null)
		{
			return new MyClass31();	
		}
		return (MyClass31) model.asMap().get("myclass31");	
	}

	@RequestMapping(value = {"/myclass31/edit", "/myclass31/edit/{myclass31Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass31 MyClass31, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass31/edit";
		}
		
		
		
		this.myClass31Service.save(MyClass31);
		session.setComplete();
		return "redirect:/myclass31/list";	
	}


}
