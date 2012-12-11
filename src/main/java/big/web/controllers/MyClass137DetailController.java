package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass137Validator;
import big.services.MyClass137Service;
import big.domain.MyClass137;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass137.class)
public class MyClass137DetailController
{

	
	@Autowired
	private MyClass137Service myClass137Service;
    

	@RequestMapping(value = "/myclass137/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass137/edit";	
	}

	@RequestMapping(value = "/myclass137/detail/{myClass137Id}")
	public String details (@PathVariable(value = "myClass137Id") Long myClass137Id, Model model) 
	{
		MyClass137 myClass137 = this.myClass137Service.findById(myClass137Id);
		model.addAttribute(myClass137);
		return "myclass137/detail";	
	}

	@RequestMapping(value = "/myclass137/edit/{myClass137Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass137Id") Long myClass137Id, Model model) 
	{
		MyClass137 myClass137 = this.myClass137Service.findById(myClass137Id);
		model.addAttribute(myClass137);
		return "myclass137/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass137Validator());	
	}

	@RequestMapping(value = "/myclass137/edit", method = RequestMethod.GET)
	public MyClass137 newMyClass137 (Model model) 
	{
		if(model != null && model.asMap().get("myclass137") == null)
		{
			return new MyClass137();	
		}
		return (MyClass137) model.asMap().get("myclass137");	
	}

	@RequestMapping(value = {"/myclass137/edit", "/myclass137/edit/{myclass137Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass137 MyClass137, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass137/edit";
		}
		
		
		
		this.myClass137Service.save(MyClass137);
		session.setComplete();
		return "redirect:/myclass137/list";	
	}


}
