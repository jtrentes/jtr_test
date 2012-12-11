package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass101;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.services.MyClass101Service;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass101Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass101.class)
public class MyClass101DetailController
{

	
	@Autowired
	private MyClass101Service myClass101Service;
    

	@RequestMapping(value = "/myclass101/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass101/edit";	
	}

	@RequestMapping(value = "/myclass101/detail/{myClass101Id}")
	public String details (@PathVariable(value = "myClass101Id") Long myClass101Id, Model model) 
	{
		MyClass101 myClass101 = this.myClass101Service.findById(myClass101Id);
		model.addAttribute(myClass101);
		return "myclass101/detail";	
	}

	@RequestMapping(value = "/myclass101/edit/{myClass101Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass101Id") Long myClass101Id, Model model) 
	{
		MyClass101 myClass101 = this.myClass101Service.findById(myClass101Id);
		model.addAttribute(myClass101);
		return "myclass101/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass101Validator());	
	}

	@RequestMapping(value = "/myclass101/edit", method = RequestMethod.GET)
	public MyClass101 newMyClass101 (Model model) 
	{
		if(model != null && model.asMap().get("myclass101") == null)
		{
			return new MyClass101();	
		}
		return (MyClass101) model.asMap().get("myclass101");	
	}

	@RequestMapping(value = {"/myclass101/edit", "/myclass101/edit/{myclass101Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass101 MyClass101, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass101/edit";
		}
		
		
		
		this.myClass101Service.save(MyClass101);
		session.setComplete();
		return "redirect:/myclass101/list";	
	}


}
