package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass114Validator;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass114Service;
import org.springframework.ui.Model;
import big.domain.MyClass114;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass114.class)
public class MyClass114DetailController
{

	
	@Autowired
	private MyClass114Service myClass114Service;
    

	@RequestMapping(value = "/myclass114/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass114/edit";	
	}

	@RequestMapping(value = "/myclass114/detail/{myClass114Id}")
	public String details (@PathVariable(value = "myClass114Id") Long myClass114Id, Model model) 
	{
		MyClass114 myClass114 = this.myClass114Service.findById(myClass114Id);
		model.addAttribute(myClass114);
		return "myclass114/detail";	
	}

	@RequestMapping(value = "/myclass114/edit/{myClass114Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass114Id") Long myClass114Id, Model model) 
	{
		MyClass114 myClass114 = this.myClass114Service.findById(myClass114Id);
		model.addAttribute(myClass114);
		return "myclass114/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass114Validator());	
	}

	@RequestMapping(value = "/myclass114/edit", method = RequestMethod.GET)
	public MyClass114 newMyClass114 (Model model) 
	{
		if(model != null && model.asMap().get("myclass114") == null)
		{
			return new MyClass114();	
		}
		return (MyClass114) model.asMap().get("myclass114");	
	}

	@RequestMapping(value = {"/myclass114/edit", "/myclass114/edit/{myclass114Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass114 MyClass114, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass114/edit";
		}
		
		
		
		this.myClass114Service.save(MyClass114);
		session.setComplete();
		return "redirect:/myclass114/list";	
	}


}
