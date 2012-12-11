package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass47;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass47Validator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.services.MyClass47Service;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass47.class)
public class MyClass47DetailController
{

	
	@Autowired
	private MyClass47Service myClass47Service;
    

	@RequestMapping(value = "/myclass47/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass47/edit";	
	}

	@RequestMapping(value = "/myclass47/detail/{myClass47Id}")
	public String details (@PathVariable(value = "myClass47Id") Long myClass47Id, Model model) 
	{
		MyClass47 myClass47 = this.myClass47Service.findById(myClass47Id);
		model.addAttribute(myClass47);
		return "myclass47/detail";	
	}

	@RequestMapping(value = "/myclass47/edit/{myClass47Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass47Id") Long myClass47Id, Model model) 
	{
		MyClass47 myClass47 = this.myClass47Service.findById(myClass47Id);
		model.addAttribute(myClass47);
		return "myclass47/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass47Validator());	
	}

	@RequestMapping(value = "/myclass47/edit", method = RequestMethod.GET)
	public MyClass47 newMyClass47 (Model model) 
	{
		if(model != null && model.asMap().get("myclass47") == null)
		{
			return new MyClass47();	
		}
		return (MyClass47) model.asMap().get("myclass47");	
	}

	@RequestMapping(value = {"/myclass47/edit", "/myclass47/edit/{myclass47Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass47 MyClass47, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass47/edit";
		}
		
		
		
		this.myClass47Service.save(MyClass47);
		session.setComplete();
		return "redirect:/myclass47/list";	
	}


}
