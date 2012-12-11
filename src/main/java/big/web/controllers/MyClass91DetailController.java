package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass91Validator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass91Service;
import big.domain.MyClass91;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass91.class)
public class MyClass91DetailController
{

	
	@Autowired
	private MyClass91Service myClass91Service;
    

	@RequestMapping(value = "/myclass91/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass91/edit";	
	}

	@RequestMapping(value = "/myclass91/detail/{myClass91Id}")
	public String details (@PathVariable(value = "myClass91Id") Long myClass91Id, Model model) 
	{
		MyClass91 myClass91 = this.myClass91Service.findById(myClass91Id);
		model.addAttribute(myClass91);
		return "myclass91/detail";	
	}

	@RequestMapping(value = "/myclass91/edit/{myClass91Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass91Id") Long myClass91Id, Model model) 
	{
		MyClass91 myClass91 = this.myClass91Service.findById(myClass91Id);
		model.addAttribute(myClass91);
		return "myclass91/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass91Validator());	
	}

	@RequestMapping(value = "/myclass91/edit", method = RequestMethod.GET)
	public MyClass91 newMyClass91 (Model model) 
	{
		if(model != null && model.asMap().get("myclass91") == null)
		{
			return new MyClass91();	
		}
		return (MyClass91) model.asMap().get("myclass91");	
	}

	@RequestMapping(value = {"/myclass91/edit", "/myclass91/edit/{myclass91Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass91 MyClass91, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass91/edit";
		}
		
		
		
		this.myClass91Service.save(MyClass91);
		session.setComplete();
		return "redirect:/myclass91/list";	
	}


}
