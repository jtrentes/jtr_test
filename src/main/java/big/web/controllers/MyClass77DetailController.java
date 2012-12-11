package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass77;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass77Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass77Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass77.class)
public class MyClass77DetailController
{

	
	@Autowired
	private MyClass77Service myClass77Service;
    

	@RequestMapping(value = "/myclass77/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass77/edit";	
	}

	@RequestMapping(value = "/myclass77/detail/{myClass77Id}")
	public String details (@PathVariable(value = "myClass77Id") Long myClass77Id, Model model) 
	{
		MyClass77 myClass77 = this.myClass77Service.findById(myClass77Id);
		model.addAttribute(myClass77);
		return "myclass77/detail";	
	}

	@RequestMapping(value = "/myclass77/edit/{myClass77Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass77Id") Long myClass77Id, Model model) 
	{
		MyClass77 myClass77 = this.myClass77Service.findById(myClass77Id);
		model.addAttribute(myClass77);
		return "myclass77/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass77Validator());	
	}

	@RequestMapping(value = "/myclass77/edit", method = RequestMethod.GET)
	public MyClass77 newMyClass77 (Model model) 
	{
		if(model != null && model.asMap().get("myclass77") == null)
		{
			return new MyClass77();	
		}
		return (MyClass77) model.asMap().get("myclass77");	
	}

	@RequestMapping(value = {"/myclass77/edit", "/myclass77/edit/{myclass77Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass77 MyClass77, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass77/edit";
		}
		
		
		
		this.myClass77Service.save(MyClass77);
		session.setComplete();
		return "redirect:/myclass77/list";	
	}


}
