package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass110Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.domain.MyClass110;
import big.web.controllers.validator.MyClass110Validator;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass110.class)
public class MyClass110DetailController
{

	
	@Autowired
	private MyClass110Service myClass110Service;
    

	@RequestMapping(value = "/myclass110/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass110/edit";	
	}

	@RequestMapping(value = "/myclass110/detail/{myClass110Id}")
	public String details (@PathVariable(value = "myClass110Id") Long myClass110Id, Model model) 
	{
		MyClass110 myClass110 = this.myClass110Service.findById(myClass110Id);
		model.addAttribute(myClass110);
		return "myclass110/detail";	
	}

	@RequestMapping(value = "/myclass110/edit/{myClass110Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass110Id") Long myClass110Id, Model model) 
	{
		MyClass110 myClass110 = this.myClass110Service.findById(myClass110Id);
		model.addAttribute(myClass110);
		return "myclass110/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass110Validator());	
	}

	@RequestMapping(value = "/myclass110/edit", method = RequestMethod.GET)
	public MyClass110 newMyClass110 (Model model) 
	{
		if(model != null && model.asMap().get("myclass110") == null)
		{
			return new MyClass110();	
		}
		return (MyClass110) model.asMap().get("myclass110");	
	}

	@RequestMapping(value = {"/myclass110/edit", "/myclass110/edit/{myclass110Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass110 MyClass110, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass110/edit";
		}
		
		
		
		this.myClass110Service.save(MyClass110);
		session.setComplete();
		return "redirect:/myclass110/list";	
	}


}
