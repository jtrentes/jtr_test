package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass126;
import big.services.MyClass126Service;
import big.web.controllers.validator.MyClass126Validator;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass126.class)
public class MyClass126DetailController
{

	
	@Autowired
	private MyClass126Service myClass126Service;
    

	@RequestMapping(value = "/myclass126/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass126/edit";	
	}

	@RequestMapping(value = "/myclass126/detail/{myClass126Id}")
	public String details (@PathVariable(value = "myClass126Id") Long myClass126Id, Model model) 
	{
		MyClass126 myClass126 = this.myClass126Service.findById(myClass126Id);
		model.addAttribute(myClass126);
		return "myclass126/detail";	
	}

	@RequestMapping(value = "/myclass126/edit/{myClass126Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass126Id") Long myClass126Id, Model model) 
	{
		MyClass126 myClass126 = this.myClass126Service.findById(myClass126Id);
		model.addAttribute(myClass126);
		return "myclass126/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass126Validator());	
	}

	@RequestMapping(value = "/myclass126/edit", method = RequestMethod.GET)
	public MyClass126 newMyClass126 (Model model) 
	{
		if(model != null && model.asMap().get("myclass126") == null)
		{
			return new MyClass126();	
		}
		return (MyClass126) model.asMap().get("myclass126");	
	}

	@RequestMapping(value = {"/myclass126/edit", "/myclass126/edit/{myclass126Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass126 MyClass126, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass126/edit";
		}
		
		
		
		this.myClass126Service.save(MyClass126);
		session.setComplete();
		return "redirect:/myclass126/list";	
	}


}
