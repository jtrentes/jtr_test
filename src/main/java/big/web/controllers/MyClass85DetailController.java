package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.domain.MyClass85;
import big.services.MyClass85Service;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass85Validator;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
@SessionAttributes(types = MyClass85.class)
public class MyClass85DetailController
{

	
	@Autowired
	private MyClass85Service myClass85Service;
    

	@RequestMapping(value = "/myclass85/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass85/edit";	
	}

	@RequestMapping(value = "/myclass85/detail/{myClass85Id}")
	public String details (@PathVariable(value = "myClass85Id") Long myClass85Id, Model model) 
	{
		MyClass85 myClass85 = this.myClass85Service.findById(myClass85Id);
		model.addAttribute(myClass85);
		return "myclass85/detail";	
	}

	@RequestMapping(value = "/myclass85/edit/{myClass85Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass85Id") Long myClass85Id, Model model) 
	{
		MyClass85 myClass85 = this.myClass85Service.findById(myClass85Id);
		model.addAttribute(myClass85);
		return "myclass85/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass85Validator());	
	}

	@RequestMapping(value = "/myclass85/edit", method = RequestMethod.GET)
	public MyClass85 newMyClass85 (Model model) 
	{
		if(model != null && model.asMap().get("myclass85") == null)
		{
			return new MyClass85();	
		}
		return (MyClass85) model.asMap().get("myclass85");	
	}

	@RequestMapping(value = {"/myclass85/edit", "/myclass85/edit/{myclass85Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass85 MyClass85, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass85/edit";
		}
		
		
		
		this.myClass85Service.save(MyClass85);
		session.setComplete();
		return "redirect:/myclass85/list";	
	}


}
