package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass152;
import big.services.MyClass152Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass152Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass152.class)
public class MyClass152DetailController
{

	
	@Autowired
	private MyClass152Service myClass152Service;
    

	@RequestMapping(value = "/myclass152/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass152/edit";	
	}

	@RequestMapping(value = "/myclass152/detail/{myClass152Id}")
	public String details (@PathVariable(value = "myClass152Id") Long myClass152Id, Model model) 
	{
		MyClass152 myClass152 = this.myClass152Service.findById(myClass152Id);
		model.addAttribute(myClass152);
		return "myclass152/detail";	
	}

	@RequestMapping(value = "/myclass152/edit/{myClass152Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass152Id") Long myClass152Id, Model model) 
	{
		MyClass152 myClass152 = this.myClass152Service.findById(myClass152Id);
		model.addAttribute(myClass152);
		return "myclass152/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass152Validator());	
	}

	@RequestMapping(value = "/myclass152/edit", method = RequestMethod.GET)
	public MyClass152 newMyClass152 (Model model) 
	{
		if(model != null && model.asMap().get("myclass152") == null)
		{
			return new MyClass152();	
		}
		return (MyClass152) model.asMap().get("myclass152");	
	}

	@RequestMapping(value = {"/myclass152/edit", "/myclass152/edit/{myclass152Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass152 MyClass152, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass152/edit";
		}
		
		
		
		this.myClass152Service.save(MyClass152);
		session.setComplete();
		return "redirect:/myclass152/list";	
	}


}
