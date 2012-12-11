package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass44Validator;
import big.domain.MyClass44;
import big.services.MyClass44Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass44.class)
public class MyClass44DetailController
{

	
	@Autowired
	private MyClass44Service myClass44Service;
    

	@RequestMapping(value = "/myclass44/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass44/edit";	
	}

	@RequestMapping(value = "/myclass44/detail/{myClass44Id}")
	public String details (@PathVariable(value = "myClass44Id") Long myClass44Id, Model model) 
	{
		MyClass44 myClass44 = this.myClass44Service.findById(myClass44Id);
		model.addAttribute(myClass44);
		return "myclass44/detail";	
	}

	@RequestMapping(value = "/myclass44/edit/{myClass44Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass44Id") Long myClass44Id, Model model) 
	{
		MyClass44 myClass44 = this.myClass44Service.findById(myClass44Id);
		model.addAttribute(myClass44);
		return "myclass44/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass44Validator());	
	}

	@RequestMapping(value = "/myclass44/edit", method = RequestMethod.GET)
	public MyClass44 newMyClass44 (Model model) 
	{
		if(model != null && model.asMap().get("myclass44") == null)
		{
			return new MyClass44();	
		}
		return (MyClass44) model.asMap().get("myclass44");	
	}

	@RequestMapping(value = {"/myclass44/edit", "/myclass44/edit/{myclass44Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass44 MyClass44, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass44/edit";
		}
		
		
		
		this.myClass44Service.save(MyClass44);
		session.setComplete();
		return "redirect:/myclass44/list";	
	}


}
