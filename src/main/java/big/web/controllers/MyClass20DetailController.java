package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass20;
import big.web.controllers.validator.MyClass20Validator;
import big.services.MyClass20Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
@SessionAttributes(types = MyClass20.class)
public class MyClass20DetailController
{

	
	@Autowired
	private MyClass20Service myClass20Service;
    

	@RequestMapping(value = "/myclass20/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass20/edit";	
	}

	@RequestMapping(value = "/myclass20/detail/{myClass20Id}")
	public String details (@PathVariable(value = "myClass20Id") Long myClass20Id, Model model) 
	{
		MyClass20 myClass20 = this.myClass20Service.findById(myClass20Id);
		model.addAttribute(myClass20);
		return "myclass20/detail";	
	}

	@RequestMapping(value = "/myclass20/edit/{myClass20Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass20Id") Long myClass20Id, Model model) 
	{
		MyClass20 myClass20 = this.myClass20Service.findById(myClass20Id);
		model.addAttribute(myClass20);
		return "myclass20/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass20Validator());	
	}

	@RequestMapping(value = "/myclass20/edit", method = RequestMethod.GET)
	public MyClass20 newMyClass20 (Model model) 
	{
		if(model != null && model.asMap().get("myclass20") == null)
		{
			return new MyClass20();	
		}
		return (MyClass20) model.asMap().get("myclass20");	
	}

	@RequestMapping(value = {"/myclass20/edit", "/myclass20/edit/{myclass20Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass20 MyClass20, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass20/edit";
		}
		
		
		
		this.myClass20Service.save(MyClass20);
		session.setComplete();
		return "redirect:/myclass20/list";	
	}


}
