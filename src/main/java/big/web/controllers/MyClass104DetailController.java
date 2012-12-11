package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass104;
import big.services.MyClass104Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass104Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass104.class)
public class MyClass104DetailController
{

	
	@Autowired
	private MyClass104Service myClass104Service;
    

	@RequestMapping(value = "/myclass104/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass104/edit";	
	}

	@RequestMapping(value = "/myclass104/detail/{myClass104Id}")
	public String details (@PathVariable(value = "myClass104Id") Long myClass104Id, Model model) 
	{
		MyClass104 myClass104 = this.myClass104Service.findById(myClass104Id);
		model.addAttribute(myClass104);
		return "myclass104/detail";	
	}

	@RequestMapping(value = "/myclass104/edit/{myClass104Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass104Id") Long myClass104Id, Model model) 
	{
		MyClass104 myClass104 = this.myClass104Service.findById(myClass104Id);
		model.addAttribute(myClass104);
		return "myclass104/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass104Validator());	
	}

	@RequestMapping(value = "/myclass104/edit", method = RequestMethod.GET)
	public MyClass104 newMyClass104 (Model model) 
	{
		if(model != null && model.asMap().get("myclass104") == null)
		{
			return new MyClass104();	
		}
		return (MyClass104) model.asMap().get("myclass104");	
	}

	@RequestMapping(value = {"/myclass104/edit", "/myclass104/edit/{myclass104Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass104 MyClass104, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass104/edit";
		}
		
		
		
		this.myClass104Service.save(MyClass104);
		session.setComplete();
		return "redirect:/myclass104/list";	
	}


}
