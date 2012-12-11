package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass153;
import big.web.controllers.validator.MyClass153Validator;
import big.services.MyClass153Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass153.class)
public class MyClass153DetailController
{

	
	@Autowired
	private MyClass153Service myClass153Service;
    

	@RequestMapping(value = "/myclass153/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass153/edit";	
	}

	@RequestMapping(value = "/myclass153/detail/{myClass153Id}")
	public String details (@PathVariable(value = "myClass153Id") Long myClass153Id, Model model) 
	{
		MyClass153 myClass153 = this.myClass153Service.findById(myClass153Id);
		model.addAttribute(myClass153);
		return "myclass153/detail";	
	}

	@RequestMapping(value = "/myclass153/edit/{myClass153Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass153Id") Long myClass153Id, Model model) 
	{
		MyClass153 myClass153 = this.myClass153Service.findById(myClass153Id);
		model.addAttribute(myClass153);
		return "myclass153/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass153Validator());	
	}

	@RequestMapping(value = "/myclass153/edit", method = RequestMethod.GET)
	public MyClass153 newMyClass153 (Model model) 
	{
		if(model != null && model.asMap().get("myclass153") == null)
		{
			return new MyClass153();	
		}
		return (MyClass153) model.asMap().get("myclass153");	
	}

	@RequestMapping(value = {"/myclass153/edit", "/myclass153/edit/{myclass153Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass153 MyClass153, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass153/edit";
		}
		
		
		
		this.myClass153Service.save(MyClass153);
		session.setComplete();
		return "redirect:/myclass153/list";	
	}


}
