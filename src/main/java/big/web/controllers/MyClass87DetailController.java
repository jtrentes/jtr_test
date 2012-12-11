package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass87;
import org.springframework.ui.Model;
import big.services.MyClass87Service;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass87Validator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass87.class)
public class MyClass87DetailController
{

	
	@Autowired
	private MyClass87Service myClass87Service;
    

	@RequestMapping(value = "/myclass87/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass87/edit";	
	}

	@RequestMapping(value = "/myclass87/detail/{myClass87Id}")
	public String details (@PathVariable(value = "myClass87Id") Long myClass87Id, Model model) 
	{
		MyClass87 myClass87 = this.myClass87Service.findById(myClass87Id);
		model.addAttribute(myClass87);
		return "myclass87/detail";	
	}

	@RequestMapping(value = "/myclass87/edit/{myClass87Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass87Id") Long myClass87Id, Model model) 
	{
		MyClass87 myClass87 = this.myClass87Service.findById(myClass87Id);
		model.addAttribute(myClass87);
		return "myclass87/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass87Validator());	
	}

	@RequestMapping(value = "/myclass87/edit", method = RequestMethod.GET)
	public MyClass87 newMyClass87 (Model model) 
	{
		if(model != null && model.asMap().get("myclass87") == null)
		{
			return new MyClass87();	
		}
		return (MyClass87) model.asMap().get("myclass87");	
	}

	@RequestMapping(value = {"/myclass87/edit", "/myclass87/edit/{myclass87Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass87 MyClass87, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass87/edit";
		}
		
		
		
		this.myClass87Service.save(MyClass87);
		session.setComplete();
		return "redirect:/myclass87/list";	
	}


}
