package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass141Validator;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import big.domain.MyClass141;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.services.MyClass141Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass141.class)
public class MyClass141DetailController
{

	
	@Autowired
	private MyClass141Service myClass141Service;
    

	@RequestMapping(value = "/myclass141/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass141/edit";	
	}

	@RequestMapping(value = "/myclass141/detail/{myClass141Id}")
	public String details (@PathVariable(value = "myClass141Id") Long myClass141Id, Model model) 
	{
		MyClass141 myClass141 = this.myClass141Service.findById(myClass141Id);
		model.addAttribute(myClass141);
		return "myclass141/detail";	
	}

	@RequestMapping(value = "/myclass141/edit/{myClass141Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass141Id") Long myClass141Id, Model model) 
	{
		MyClass141 myClass141 = this.myClass141Service.findById(myClass141Id);
		model.addAttribute(myClass141);
		return "myclass141/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass141Validator());	
	}

	@RequestMapping(value = "/myclass141/edit", method = RequestMethod.GET)
	public MyClass141 newMyClass141 (Model model) 
	{
		if(model != null && model.asMap().get("myclass141") == null)
		{
			return new MyClass141();	
		}
		return (MyClass141) model.asMap().get("myclass141");	
	}

	@RequestMapping(value = {"/myclass141/edit", "/myclass141/edit/{myclass141Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass141 MyClass141, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass141/edit";
		}
		
		
		
		this.myClass141Service.save(MyClass141);
		session.setComplete();
		return "redirect:/myclass141/list";	
	}


}
