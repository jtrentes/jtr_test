package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.services.MyClass48Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass48Validator;
import big.domain.MyClass48;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass48.class)
public class MyClass48DetailController
{

	
	@Autowired
	private MyClass48Service myClass48Service;
    

	@RequestMapping(value = "/myclass48/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass48/edit";	
	}

	@RequestMapping(value = "/myclass48/detail/{myClass48Id}")
	public String details (@PathVariable(value = "myClass48Id") Long myClass48Id, Model model) 
	{
		MyClass48 myClass48 = this.myClass48Service.findById(myClass48Id);
		model.addAttribute(myClass48);
		return "myclass48/detail";	
	}

	@RequestMapping(value = "/myclass48/edit/{myClass48Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass48Id") Long myClass48Id, Model model) 
	{
		MyClass48 myClass48 = this.myClass48Service.findById(myClass48Id);
		model.addAttribute(myClass48);
		return "myclass48/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass48Validator());	
	}

	@RequestMapping(value = "/myclass48/edit", method = RequestMethod.GET)
	public MyClass48 newMyClass48 (Model model) 
	{
		if(model != null && model.asMap().get("myclass48") == null)
		{
			return new MyClass48();	
		}
		return (MyClass48) model.asMap().get("myclass48");	
	}

	@RequestMapping(value = {"/myclass48/edit", "/myclass48/edit/{myclass48Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass48 MyClass48, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass48/edit";
		}
		
		
		
		this.myClass48Service.save(MyClass48);
		session.setComplete();
		return "redirect:/myclass48/list";	
	}


}
