package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass127Service;
import big.domain.MyClass127;
import big.web.controllers.validator.MyClass127Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass127.class)
public class MyClass127DetailController
{

	
	@Autowired
	private MyClass127Service myClass127Service;
    

	@RequestMapping(value = "/myclass127/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass127/edit";	
	}

	@RequestMapping(value = "/myclass127/detail/{myClass127Id}")
	public String details (@PathVariable(value = "myClass127Id") Long myClass127Id, Model model) 
	{
		MyClass127 myClass127 = this.myClass127Service.findById(myClass127Id);
		model.addAttribute(myClass127);
		return "myclass127/detail";	
	}

	@RequestMapping(value = "/myclass127/edit/{myClass127Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass127Id") Long myClass127Id, Model model) 
	{
		MyClass127 myClass127 = this.myClass127Service.findById(myClass127Id);
		model.addAttribute(myClass127);
		return "myclass127/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass127Validator());	
	}

	@RequestMapping(value = "/myclass127/edit", method = RequestMethod.GET)
	public MyClass127 newMyClass127 (Model model) 
	{
		if(model != null && model.asMap().get("myclass127") == null)
		{
			return new MyClass127();	
		}
		return (MyClass127) model.asMap().get("myclass127");	
	}

	@RequestMapping(value = {"/myclass127/edit", "/myclass127/edit/{myclass127Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass127 MyClass127, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass127/edit";
		}
		
		
		
		this.myClass127Service.save(MyClass127);
		session.setComplete();
		return "redirect:/myclass127/list";	
	}


}
