package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass136Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass136Validator;
import big.domain.MyClass136;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass136.class)
public class MyClass136DetailController
{

	
	@Autowired
	private MyClass136Service myClass136Service;
    

	@RequestMapping(value = "/myclass136/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass136/edit";	
	}

	@RequestMapping(value = "/myclass136/detail/{myClass136Id}")
	public String details (@PathVariable(value = "myClass136Id") Long myClass136Id, Model model) 
	{
		MyClass136 myClass136 = this.myClass136Service.findById(myClass136Id);
		model.addAttribute(myClass136);
		return "myclass136/detail";	
	}

	@RequestMapping(value = "/myclass136/edit/{myClass136Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass136Id") Long myClass136Id, Model model) 
	{
		MyClass136 myClass136 = this.myClass136Service.findById(myClass136Id);
		model.addAttribute(myClass136);
		return "myclass136/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass136Validator());	
	}

	@RequestMapping(value = "/myclass136/edit", method = RequestMethod.GET)
	public MyClass136 newMyClass136 (Model model) 
	{
		if(model != null && model.asMap().get("myclass136") == null)
		{
			return new MyClass136();	
		}
		return (MyClass136) model.asMap().get("myclass136");	
	}

	@RequestMapping(value = {"/myclass136/edit", "/myclass136/edit/{myclass136Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass136 MyClass136, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass136/edit";
		}
		
		
		
		this.myClass136Service.save(MyClass136);
		session.setComplete();
		return "redirect:/myclass136/list";	
	}


}
