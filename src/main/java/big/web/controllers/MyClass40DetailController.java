package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass40;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass40Validator;
import big.services.MyClass40Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass40.class)
public class MyClass40DetailController
{

	
	@Autowired
	private MyClass40Service myClass40Service;
    

	@RequestMapping(value = "/myclass40/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass40/edit";	
	}

	@RequestMapping(value = "/myclass40/detail/{myClass40Id}")
	public String details (@PathVariable(value = "myClass40Id") Long myClass40Id, Model model) 
	{
		MyClass40 myClass40 = this.myClass40Service.findById(myClass40Id);
		model.addAttribute(myClass40);
		return "myclass40/detail";	
	}

	@RequestMapping(value = "/myclass40/edit/{myClass40Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass40Id") Long myClass40Id, Model model) 
	{
		MyClass40 myClass40 = this.myClass40Service.findById(myClass40Id);
		model.addAttribute(myClass40);
		return "myclass40/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass40Validator());	
	}

	@RequestMapping(value = "/myclass40/edit", method = RequestMethod.GET)
	public MyClass40 newMyClass40 (Model model) 
	{
		if(model != null && model.asMap().get("myclass40") == null)
		{
			return new MyClass40();	
		}
		return (MyClass40) model.asMap().get("myclass40");	
	}

	@RequestMapping(value = {"/myclass40/edit", "/myclass40/edit/{myclass40Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass40 MyClass40, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass40/edit";
		}
		
		
		
		this.myClass40Service.save(MyClass40);
		session.setComplete();
		return "redirect:/myclass40/list";	
	}


}
