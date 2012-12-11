package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass64Validator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass64;
import big.services.MyClass64Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass64.class)
public class MyClass64DetailController
{

	
	@Autowired
	private MyClass64Service myClass64Service;
    

	@RequestMapping(value = "/myclass64/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass64/edit";	
	}

	@RequestMapping(value = "/myclass64/detail/{myClass64Id}")
	public String details (@PathVariable(value = "myClass64Id") Long myClass64Id, Model model) 
	{
		MyClass64 myClass64 = this.myClass64Service.findById(myClass64Id);
		model.addAttribute(myClass64);
		return "myclass64/detail";	
	}

	@RequestMapping(value = "/myclass64/edit/{myClass64Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass64Id") Long myClass64Id, Model model) 
	{
		MyClass64 myClass64 = this.myClass64Service.findById(myClass64Id);
		model.addAttribute(myClass64);
		return "myclass64/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass64Validator());	
	}

	@RequestMapping(value = "/myclass64/edit", method = RequestMethod.GET)
	public MyClass64 newMyClass64 (Model model) 
	{
		if(model != null && model.asMap().get("myclass64") == null)
		{
			return new MyClass64();	
		}
		return (MyClass64) model.asMap().get("myclass64");	
	}

	@RequestMapping(value = {"/myclass64/edit", "/myclass64/edit/{myclass64Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass64 MyClass64, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass64/edit";
		}
		
		
		
		this.myClass64Service.save(MyClass64);
		session.setComplete();
		return "redirect:/myclass64/list";	
	}


}
