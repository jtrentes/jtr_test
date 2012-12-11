package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass119Validator;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass119Service;
import org.springframework.validation.BindingResult;
import big.domain.MyClass119;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass119.class)
public class MyClass119DetailController
{

	
	@Autowired
	private MyClass119Service myClass119Service;
    

	@RequestMapping(value = "/myclass119/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass119/edit";	
	}

	@RequestMapping(value = "/myclass119/detail/{myClass119Id}")
	public String details (@PathVariable(value = "myClass119Id") Long myClass119Id, Model model) 
	{
		MyClass119 myClass119 = this.myClass119Service.findById(myClass119Id);
		model.addAttribute(myClass119);
		return "myclass119/detail";	
	}

	@RequestMapping(value = "/myclass119/edit/{myClass119Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass119Id") Long myClass119Id, Model model) 
	{
		MyClass119 myClass119 = this.myClass119Service.findById(myClass119Id);
		model.addAttribute(myClass119);
		return "myclass119/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass119Validator());	
	}

	@RequestMapping(value = "/myclass119/edit", method = RequestMethod.GET)
	public MyClass119 newMyClass119 (Model model) 
	{
		if(model != null && model.asMap().get("myclass119") == null)
		{
			return new MyClass119();	
		}
		return (MyClass119) model.asMap().get("myclass119");	
	}

	@RequestMapping(value = {"/myclass119/edit", "/myclass119/edit/{myclass119Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass119 MyClass119, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass119/edit";
		}
		
		
		
		this.myClass119Service.save(MyClass119);
		session.setComplete();
		return "redirect:/myclass119/list";	
	}


}
