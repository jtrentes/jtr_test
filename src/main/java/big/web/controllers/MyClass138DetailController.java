package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass138Service;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass138;
import big.web.controllers.validator.MyClass138Validator;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass138.class)
public class MyClass138DetailController
{

	
	@Autowired
	private MyClass138Service myClass138Service;
    

	@RequestMapping(value = "/myclass138/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass138/edit";	
	}

	@RequestMapping(value = "/myclass138/detail/{myClass138Id}")
	public String details (@PathVariable(value = "myClass138Id") Long myClass138Id, Model model) 
	{
		MyClass138 myClass138 = this.myClass138Service.findById(myClass138Id);
		model.addAttribute(myClass138);
		return "myclass138/detail";	
	}

	@RequestMapping(value = "/myclass138/edit/{myClass138Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass138Id") Long myClass138Id, Model model) 
	{
		MyClass138 myClass138 = this.myClass138Service.findById(myClass138Id);
		model.addAttribute(myClass138);
		return "myclass138/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass138Validator());	
	}

	@RequestMapping(value = "/myclass138/edit", method = RequestMethod.GET)
	public MyClass138 newMyClass138 (Model model) 
	{
		if(model != null && model.asMap().get("myclass138") == null)
		{
			return new MyClass138();	
		}
		return (MyClass138) model.asMap().get("myclass138");	
	}

	@RequestMapping(value = {"/myclass138/edit", "/myclass138/edit/{myclass138Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass138 MyClass138, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass138/edit";
		}
		
		
		
		this.myClass138Service.save(MyClass138);
		session.setComplete();
		return "redirect:/myclass138/list";	
	}


}
