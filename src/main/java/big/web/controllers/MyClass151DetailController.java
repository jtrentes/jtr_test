package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass151;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass151Validator;
import org.springframework.validation.BindingResult;
import big.services.MyClass151Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass151.class)
public class MyClass151DetailController
{

	
	@Autowired
	private MyClass151Service myClass151Service;
    

	@RequestMapping(value = "/myclass151/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass151/edit";	
	}

	@RequestMapping(value = "/myclass151/detail/{myClass151Id}")
	public String details (@PathVariable(value = "myClass151Id") Long myClass151Id, Model model) 
	{
		MyClass151 myClass151 = this.myClass151Service.findById(myClass151Id);
		model.addAttribute(myClass151);
		return "myclass151/detail";	
	}

	@RequestMapping(value = "/myclass151/edit/{myClass151Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass151Id") Long myClass151Id, Model model) 
	{
		MyClass151 myClass151 = this.myClass151Service.findById(myClass151Id);
		model.addAttribute(myClass151);
		return "myclass151/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass151Validator());	
	}

	@RequestMapping(value = "/myclass151/edit", method = RequestMethod.GET)
	public MyClass151 newMyClass151 (Model model) 
	{
		if(model != null && model.asMap().get("myclass151") == null)
		{
			return new MyClass151();	
		}
		return (MyClass151) model.asMap().get("myclass151");	
	}

	@RequestMapping(value = {"/myclass151/edit", "/myclass151/edit/{myclass151Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass151 MyClass151, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass151/edit";
		}
		
		
		
		this.myClass151Service.save(MyClass151);
		session.setComplete();
		return "redirect:/myclass151/list";	
	}


}
