package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.services.MyClass16Service;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass16;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass16Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass16.class)
public class MyClass16DetailController
{

	
	@Autowired
	private MyClass16Service myClass16Service;
    

	@RequestMapping(value = "/myclass16/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass16/edit";	
	}

	@RequestMapping(value = "/myclass16/detail/{myClass16Id}")
	public String details (@PathVariable(value = "myClass16Id") Long myClass16Id, Model model) 
	{
		MyClass16 myClass16 = this.myClass16Service.findById(myClass16Id);
		model.addAttribute(myClass16);
		return "myclass16/detail";	
	}

	@RequestMapping(value = "/myclass16/edit/{myClass16Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass16Id") Long myClass16Id, Model model) 
	{
		MyClass16 myClass16 = this.myClass16Service.findById(myClass16Id);
		model.addAttribute(myClass16);
		return "myclass16/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass16Validator());	
	}

	@RequestMapping(value = "/myclass16/edit", method = RequestMethod.GET)
	public MyClass16 newMyClass16 (Model model) 
	{
		if(model != null && model.asMap().get("myclass16") == null)
		{
			return new MyClass16();	
		}
		return (MyClass16) model.asMap().get("myclass16");	
	}

	@RequestMapping(value = {"/myclass16/edit", "/myclass16/edit/{myclass16Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass16 MyClass16, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass16/edit";
		}
		
		
		
		this.myClass16Service.save(MyClass16);
		session.setComplete();
		return "redirect:/myclass16/list";	
	}


}
