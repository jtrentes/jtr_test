package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import big.services.MyClass121Service;
import big.web.controllers.validator.MyClass121Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.domain.MyClass121;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
@SessionAttributes(types = MyClass121.class)
public class MyClass121DetailController
{

	
	@Autowired
	private MyClass121Service myClass121Service;
    

	@RequestMapping(value = "/myclass121/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass121/edit";	
	}

	@RequestMapping(value = "/myclass121/detail/{myClass121Id}")
	public String details (@PathVariable(value = "myClass121Id") Long myClass121Id, Model model) 
	{
		MyClass121 myClass121 = this.myClass121Service.findById(myClass121Id);
		model.addAttribute(myClass121);
		return "myclass121/detail";	
	}

	@RequestMapping(value = "/myclass121/edit/{myClass121Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass121Id") Long myClass121Id, Model model) 
	{
		MyClass121 myClass121 = this.myClass121Service.findById(myClass121Id);
		model.addAttribute(myClass121);
		return "myclass121/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass121Validator());	
	}

	@RequestMapping(value = "/myclass121/edit", method = RequestMethod.GET)
	public MyClass121 newMyClass121 (Model model) 
	{
		if(model != null && model.asMap().get("myclass121") == null)
		{
			return new MyClass121();	
		}
		return (MyClass121) model.asMap().get("myclass121");	
	}

	@RequestMapping(value = {"/myclass121/edit", "/myclass121/edit/{myclass121Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass121 MyClass121, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass121/edit";
		}
		
		
		
		this.myClass121Service.save(MyClass121);
		session.setComplete();
		return "redirect:/myclass121/list";	
	}


}
