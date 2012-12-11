package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.services.MyClass38Service;
import big.domain.MyClass38;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass38Validator;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass38.class)
public class MyClass38DetailController
{

	
	@Autowired
	private MyClass38Service myClass38Service;
    

	@RequestMapping(value = "/myclass38/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass38/edit";	
	}

	@RequestMapping(value = "/myclass38/detail/{myClass38Id}")
	public String details (@PathVariable(value = "myClass38Id") Long myClass38Id, Model model) 
	{
		MyClass38 myClass38 = this.myClass38Service.findById(myClass38Id);
		model.addAttribute(myClass38);
		return "myclass38/detail";	
	}

	@RequestMapping(value = "/myclass38/edit/{myClass38Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass38Id") Long myClass38Id, Model model) 
	{
		MyClass38 myClass38 = this.myClass38Service.findById(myClass38Id);
		model.addAttribute(myClass38);
		return "myclass38/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass38Validator());	
	}

	@RequestMapping(value = "/myclass38/edit", method = RequestMethod.GET)
	public MyClass38 newMyClass38 (Model model) 
	{
		if(model != null && model.asMap().get("myclass38") == null)
		{
			return new MyClass38();	
		}
		return (MyClass38) model.asMap().get("myclass38");	
	}

	@RequestMapping(value = {"/myclass38/edit", "/myclass38/edit/{myclass38Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass38 MyClass38, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass38/edit";
		}
		
		
		
		this.myClass38Service.save(MyClass38);
		session.setComplete();
		return "redirect:/myclass38/list";	
	}


}
