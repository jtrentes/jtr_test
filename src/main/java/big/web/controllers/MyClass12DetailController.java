package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.services.MyClass12Service;
import big.domain.MyClass12;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass12Validator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass12.class)
public class MyClass12DetailController
{

	
	@Autowired
	private MyClass12Service myClass12Service;
    

	@RequestMapping(value = "/myclass12/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass12/edit";	
	}

	@RequestMapping(value = "/myclass12/detail/{myClass12Id}")
	public String details (@PathVariable(value = "myClass12Id") Long myClass12Id, Model model) 
	{
		MyClass12 myClass12 = this.myClass12Service.findById(myClass12Id);
		model.addAttribute(myClass12);
		return "myclass12/detail";	
	}

	@RequestMapping(value = "/myclass12/edit/{myClass12Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass12Id") Long myClass12Id, Model model) 
	{
		MyClass12 myClass12 = this.myClass12Service.findById(myClass12Id);
		model.addAttribute(myClass12);
		return "myclass12/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass12Validator());	
	}

	@RequestMapping(value = "/myclass12/edit", method = RequestMethod.GET)
	public MyClass12 newMyClass12 (Model model) 
	{
		if(model != null && model.asMap().get("myclass12") == null)
		{
			return new MyClass12();	
		}
		return (MyClass12) model.asMap().get("myclass12");	
	}

	@RequestMapping(value = {"/myclass12/edit", "/myclass12/edit/{myclass12Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass12 MyClass12, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass12/edit";
		}
		
		
		
		this.myClass12Service.save(MyClass12);
		session.setComplete();
		return "redirect:/myclass12/list";	
	}


}
