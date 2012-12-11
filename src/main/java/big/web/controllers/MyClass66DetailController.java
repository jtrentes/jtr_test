package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass66Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.domain.MyClass66;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass66Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass66.class)
public class MyClass66DetailController
{

	
	@Autowired
	private MyClass66Service myClass66Service;
    

	@RequestMapping(value = "/myclass66/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass66/edit";	
	}

	@RequestMapping(value = "/myclass66/detail/{myClass66Id}")
	public String details (@PathVariable(value = "myClass66Id") Long myClass66Id, Model model) 
	{
		MyClass66 myClass66 = this.myClass66Service.findById(myClass66Id);
		model.addAttribute(myClass66);
		return "myclass66/detail";	
	}

	@RequestMapping(value = "/myclass66/edit/{myClass66Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass66Id") Long myClass66Id, Model model) 
	{
		MyClass66 myClass66 = this.myClass66Service.findById(myClass66Id);
		model.addAttribute(myClass66);
		return "myclass66/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass66Validator());	
	}

	@RequestMapping(value = "/myclass66/edit", method = RequestMethod.GET)
	public MyClass66 newMyClass66 (Model model) 
	{
		if(model != null && model.asMap().get("myclass66") == null)
		{
			return new MyClass66();	
		}
		return (MyClass66) model.asMap().get("myclass66");	
	}

	@RequestMapping(value = {"/myclass66/edit", "/myclass66/edit/{myclass66Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass66 MyClass66, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass66/edit";
		}
		
		
		
		this.myClass66Service.save(MyClass66);
		session.setComplete();
		return "redirect:/myclass66/list";	
	}


}
