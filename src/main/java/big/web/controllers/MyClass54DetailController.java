package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass54;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass54Validator;
import org.springframework.validation.BindingResult;
import big.services.MyClass54Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass54.class)
public class MyClass54DetailController
{

	
	@Autowired
	private MyClass54Service myClass54Service;
    

	@RequestMapping(value = "/myclass54/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass54/edit";	
	}

	@RequestMapping(value = "/myclass54/detail/{myClass54Id}")
	public String details (@PathVariable(value = "myClass54Id") Long myClass54Id, Model model) 
	{
		MyClass54 myClass54 = this.myClass54Service.findById(myClass54Id);
		model.addAttribute(myClass54);
		return "myclass54/detail";	
	}

	@RequestMapping(value = "/myclass54/edit/{myClass54Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass54Id") Long myClass54Id, Model model) 
	{
		MyClass54 myClass54 = this.myClass54Service.findById(myClass54Id);
		model.addAttribute(myClass54);
		return "myclass54/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass54Validator());	
	}

	@RequestMapping(value = "/myclass54/edit", method = RequestMethod.GET)
	public MyClass54 newMyClass54 (Model model) 
	{
		if(model != null && model.asMap().get("myclass54") == null)
		{
			return new MyClass54();	
		}
		return (MyClass54) model.asMap().get("myclass54");	
	}

	@RequestMapping(value = {"/myclass54/edit", "/myclass54/edit/{myclass54Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass54 MyClass54, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass54/edit";
		}
		
		
		
		this.myClass54Service.save(MyClass54);
		session.setComplete();
		return "redirect:/myclass54/list";	
	}


}
