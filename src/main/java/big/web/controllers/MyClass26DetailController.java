package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.services.MyClass26Service;
import big.domain.MyClass26;
import big.web.controllers.validator.MyClass26Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass26.class)
public class MyClass26DetailController
{

	
	@Autowired
	private MyClass26Service myClass26Service;
    

	@RequestMapping(value = "/myclass26/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass26/edit";	
	}

	@RequestMapping(value = "/myclass26/detail/{myClass26Id}")
	public String details (@PathVariable(value = "myClass26Id") Long myClass26Id, Model model) 
	{
		MyClass26 myClass26 = this.myClass26Service.findById(myClass26Id);
		model.addAttribute(myClass26);
		return "myclass26/detail";	
	}

	@RequestMapping(value = "/myclass26/edit/{myClass26Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass26Id") Long myClass26Id, Model model) 
	{
		MyClass26 myClass26 = this.myClass26Service.findById(myClass26Id);
		model.addAttribute(myClass26);
		return "myclass26/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass26Validator());	
	}

	@RequestMapping(value = "/myclass26/edit", method = RequestMethod.GET)
	public MyClass26 newMyClass26 (Model model) 
	{
		if(model != null && model.asMap().get("myclass26") == null)
		{
			return new MyClass26();	
		}
		return (MyClass26) model.asMap().get("myclass26");	
	}

	@RequestMapping(value = {"/myclass26/edit", "/myclass26/edit/{myclass26Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass26 MyClass26, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass26/edit";
		}
		
		
		
		this.myClass26Service.save(MyClass26);
		session.setComplete();
		return "redirect:/myclass26/list";	
	}


}
