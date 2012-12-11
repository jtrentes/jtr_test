package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass65Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.domain.MyClass65;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import big.services.MyClass65Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass65.class)
public class MyClass65DetailController
{

	
	@Autowired
	private MyClass65Service myClass65Service;
    

	@RequestMapping(value = "/myclass65/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass65/edit";	
	}

	@RequestMapping(value = "/myclass65/detail/{myClass65Id}")
	public String details (@PathVariable(value = "myClass65Id") Long myClass65Id, Model model) 
	{
		MyClass65 myClass65 = this.myClass65Service.findById(myClass65Id);
		model.addAttribute(myClass65);
		return "myclass65/detail";	
	}

	@RequestMapping(value = "/myclass65/edit/{myClass65Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass65Id") Long myClass65Id, Model model) 
	{
		MyClass65 myClass65 = this.myClass65Service.findById(myClass65Id);
		model.addAttribute(myClass65);
		return "myclass65/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass65Validator());	
	}

	@RequestMapping(value = "/myclass65/edit", method = RequestMethod.GET)
	public MyClass65 newMyClass65 (Model model) 
	{
		if(model != null && model.asMap().get("myclass65") == null)
		{
			return new MyClass65();	
		}
		return (MyClass65) model.asMap().get("myclass65");	
	}

	@RequestMapping(value = {"/myclass65/edit", "/myclass65/edit/{myclass65Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass65 MyClass65, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass65/edit";
		}
		
		
		
		this.myClass65Service.save(MyClass65);
		session.setComplete();
		return "redirect:/myclass65/list";	
	}


}
