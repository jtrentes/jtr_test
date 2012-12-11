package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.domain.MyClass36;
import big.web.controllers.validator.MyClass36Validator;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import big.services.MyClass36Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass36.class)
public class MyClass36DetailController
{

	
	@Autowired
	private MyClass36Service myClass36Service;
    

	@RequestMapping(value = "/myclass36/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass36/edit";	
	}

	@RequestMapping(value = "/myclass36/detail/{myClass36Id}")
	public String details (@PathVariable(value = "myClass36Id") Long myClass36Id, Model model) 
	{
		MyClass36 myClass36 = this.myClass36Service.findById(myClass36Id);
		model.addAttribute(myClass36);
		return "myclass36/detail";	
	}

	@RequestMapping(value = "/myclass36/edit/{myClass36Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass36Id") Long myClass36Id, Model model) 
	{
		MyClass36 myClass36 = this.myClass36Service.findById(myClass36Id);
		model.addAttribute(myClass36);
		return "myclass36/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass36Validator());	
	}

	@RequestMapping(value = "/myclass36/edit", method = RequestMethod.GET)
	public MyClass36 newMyClass36 (Model model) 
	{
		if(model != null && model.asMap().get("myclass36") == null)
		{
			return new MyClass36();	
		}
		return (MyClass36) model.asMap().get("myclass36");	
	}

	@RequestMapping(value = {"/myclass36/edit", "/myclass36/edit/{myclass36Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass36 MyClass36, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass36/edit";
		}
		
		
		
		this.myClass36Service.save(MyClass36);
		session.setComplete();
		return "redirect:/myclass36/list";	
	}


}
