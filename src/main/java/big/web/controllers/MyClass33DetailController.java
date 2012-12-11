package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass33Validator;
import big.domain.MyClass33;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass33Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass33.class)
public class MyClass33DetailController
{

	
	@Autowired
	private MyClass33Service myClass33Service;
    

	@RequestMapping(value = "/myclass33/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass33/edit";	
	}

	@RequestMapping(value = "/myclass33/detail/{myClass33Id}")
	public String details (@PathVariable(value = "myClass33Id") Long myClass33Id, Model model) 
	{
		MyClass33 myClass33 = this.myClass33Service.findById(myClass33Id);
		model.addAttribute(myClass33);
		return "myclass33/detail";	
	}

	@RequestMapping(value = "/myclass33/edit/{myClass33Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass33Id") Long myClass33Id, Model model) 
	{
		MyClass33 myClass33 = this.myClass33Service.findById(myClass33Id);
		model.addAttribute(myClass33);
		return "myclass33/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass33Validator());	
	}

	@RequestMapping(value = "/myclass33/edit", method = RequestMethod.GET)
	public MyClass33 newMyClass33 (Model model) 
	{
		if(model != null && model.asMap().get("myclass33") == null)
		{
			return new MyClass33();	
		}
		return (MyClass33) model.asMap().get("myclass33");	
	}

	@RequestMapping(value = {"/myclass33/edit", "/myclass33/edit/{myclass33Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass33 MyClass33, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass33/edit";
		}
		
		
		
		this.myClass33Service.save(MyClass33);
		session.setComplete();
		return "redirect:/myclass33/list";	
	}


}
