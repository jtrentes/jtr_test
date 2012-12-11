package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass22Service;
import big.web.controllers.validator.MyClass22Validator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.domain.MyClass22;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
@SessionAttributes(types = MyClass22.class)
public class MyClass22DetailController
{

	
	@Autowired
	private MyClass22Service myClass22Service;
    

	@RequestMapping(value = "/myclass22/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass22/edit";	
	}

	@RequestMapping(value = "/myclass22/detail/{myClass22Id}")
	public String details (@PathVariable(value = "myClass22Id") Long myClass22Id, Model model) 
	{
		MyClass22 myClass22 = this.myClass22Service.findById(myClass22Id);
		model.addAttribute(myClass22);
		return "myclass22/detail";	
	}

	@RequestMapping(value = "/myclass22/edit/{myClass22Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass22Id") Long myClass22Id, Model model) 
	{
		MyClass22 myClass22 = this.myClass22Service.findById(myClass22Id);
		model.addAttribute(myClass22);
		return "myclass22/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass22Validator());	
	}

	@RequestMapping(value = "/myclass22/edit", method = RequestMethod.GET)
	public MyClass22 newMyClass22 (Model model) 
	{
		if(model != null && model.asMap().get("myclass22") == null)
		{
			return new MyClass22();	
		}
		return (MyClass22) model.asMap().get("myclass22");	
	}

	@RequestMapping(value = {"/myclass22/edit", "/myclass22/edit/{myclass22Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass22 MyClass22, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass22/edit";
		}
		
		
		
		this.myClass22Service.save(MyClass22);
		session.setComplete();
		return "redirect:/myclass22/list";	
	}


}
