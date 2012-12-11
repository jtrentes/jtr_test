package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass159;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass159Validator;
import org.springframework.validation.BindingResult;
import big.services.MyClass159Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass159.class)
public class MyClass159DetailController
{

	
	@Autowired
	private MyClass159Service myClass159Service;
    

	@RequestMapping(value = "/myclass159/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass159/edit";	
	}

	@RequestMapping(value = "/myclass159/detail/{myClass159Id}")
	public String details (@PathVariable(value = "myClass159Id") Long myClass159Id, Model model) 
	{
		MyClass159 myClass159 = this.myClass159Service.findById(myClass159Id);
		model.addAttribute(myClass159);
		return "myclass159/detail";	
	}

	@RequestMapping(value = "/myclass159/edit/{myClass159Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass159Id") Long myClass159Id, Model model) 
	{
		MyClass159 myClass159 = this.myClass159Service.findById(myClass159Id);
		model.addAttribute(myClass159);
		return "myclass159/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass159Validator());	
	}

	@RequestMapping(value = "/myclass159/edit", method = RequestMethod.GET)
	public MyClass159 newMyClass159 (Model model) 
	{
		if(model != null && model.asMap().get("myclass159") == null)
		{
			return new MyClass159();	
		}
		return (MyClass159) model.asMap().get("myclass159");	
	}

	@RequestMapping(value = {"/myclass159/edit", "/myclass159/edit/{myclass159Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass159 MyClass159, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass159/edit";
		}
		
		
		
		this.myClass159Service.save(MyClass159);
		session.setComplete();
		return "redirect:/myclass159/list";	
	}


}
