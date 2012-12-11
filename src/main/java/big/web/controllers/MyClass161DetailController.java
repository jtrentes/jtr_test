package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass161Validator;
import big.services.MyClass161Service;
import big.domain.MyClass161;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass161.class)
public class MyClass161DetailController
{

	
	@Autowired
	private MyClass161Service myClass161Service;
    

	@RequestMapping(value = "/myclass161/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass161/edit";	
	}

	@RequestMapping(value = "/myclass161/detail/{myClass161Id}")
	public String details (@PathVariable(value = "myClass161Id") Long myClass161Id, Model model) 
	{
		MyClass161 myClass161 = this.myClass161Service.findById(myClass161Id);
		model.addAttribute(myClass161);
		return "myclass161/detail";	
	}

	@RequestMapping(value = "/myclass161/edit/{myClass161Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass161Id") Long myClass161Id, Model model) 
	{
		MyClass161 myClass161 = this.myClass161Service.findById(myClass161Id);
		model.addAttribute(myClass161);
		return "myclass161/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass161Validator());	
	}

	@RequestMapping(value = "/myclass161/edit", method = RequestMethod.GET)
	public MyClass161 newMyClass161 (Model model) 
	{
		if(model != null && model.asMap().get("myclass161") == null)
		{
			return new MyClass161();	
		}
		return (MyClass161) model.asMap().get("myclass161");	
	}

	@RequestMapping(value = {"/myclass161/edit", "/myclass161/edit/{myclass161Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass161 MyClass161, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass161/edit";
		}
		
		
		
		this.myClass161Service.save(MyClass161);
		session.setComplete();
		return "redirect:/myclass161/list";	
	}


}
