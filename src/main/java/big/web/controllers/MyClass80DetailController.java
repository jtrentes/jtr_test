package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.services.MyClass80Service;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass80Validator;
import org.springframework.validation.BindingResult;
import big.domain.MyClass80;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass80.class)
public class MyClass80DetailController
{

	
	@Autowired
	private MyClass80Service myClass80Service;
    

	@RequestMapping(value = "/myclass80/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass80/edit";	
	}

	@RequestMapping(value = "/myclass80/detail/{myClass80Id}")
	public String details (@PathVariable(value = "myClass80Id") Long myClass80Id, Model model) 
	{
		MyClass80 myClass80 = this.myClass80Service.findById(myClass80Id);
		model.addAttribute(myClass80);
		return "myclass80/detail";	
	}

	@RequestMapping(value = "/myclass80/edit/{myClass80Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass80Id") Long myClass80Id, Model model) 
	{
		MyClass80 myClass80 = this.myClass80Service.findById(myClass80Id);
		model.addAttribute(myClass80);
		return "myclass80/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass80Validator());	
	}

	@RequestMapping(value = "/myclass80/edit", method = RequestMethod.GET)
	public MyClass80 newMyClass80 (Model model) 
	{
		if(model != null && model.asMap().get("myclass80") == null)
		{
			return new MyClass80();	
		}
		return (MyClass80) model.asMap().get("myclass80");	
	}

	@RequestMapping(value = {"/myclass80/edit", "/myclass80/edit/{myclass80Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass80 MyClass80, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass80/edit";
		}
		
		
		
		this.myClass80Service.save(MyClass80);
		session.setComplete();
		return "redirect:/myclass80/list";	
	}


}
