package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass73;
import big.web.controllers.validator.MyClass73Validator;
import big.services.MyClass73Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass73.class)
public class MyClass73DetailController
{

	
	@Autowired
	private MyClass73Service myClass73Service;
    

	@RequestMapping(value = "/myclass73/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass73/edit";	
	}

	@RequestMapping(value = "/myclass73/detail/{myClass73Id}")
	public String details (@PathVariable(value = "myClass73Id") Long myClass73Id, Model model) 
	{
		MyClass73 myClass73 = this.myClass73Service.findById(myClass73Id);
		model.addAttribute(myClass73);
		return "myclass73/detail";	
	}

	@RequestMapping(value = "/myclass73/edit/{myClass73Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass73Id") Long myClass73Id, Model model) 
	{
		MyClass73 myClass73 = this.myClass73Service.findById(myClass73Id);
		model.addAttribute(myClass73);
		return "myclass73/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass73Validator());	
	}

	@RequestMapping(value = "/myclass73/edit", method = RequestMethod.GET)
	public MyClass73 newMyClass73 (Model model) 
	{
		if(model != null && model.asMap().get("myclass73") == null)
		{
			return new MyClass73();	
		}
		return (MyClass73) model.asMap().get("myclass73");	
	}

	@RequestMapping(value = {"/myclass73/edit", "/myclass73/edit/{myclass73Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass73 MyClass73, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass73/edit";
		}
		
		
		
		this.myClass73Service.save(MyClass73);
		session.setComplete();
		return "redirect:/myclass73/list";	
	}


}
