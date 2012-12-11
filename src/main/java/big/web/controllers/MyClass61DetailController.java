package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass61Validator;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass61Service;
import big.domain.MyClass61;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass61.class)
public class MyClass61DetailController
{

	
	@Autowired
	private MyClass61Service myClass61Service;
    

	@RequestMapping(value = "/myclass61/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass61/edit";	
	}

	@RequestMapping(value = "/myclass61/detail/{myClass61Id}")
	public String details (@PathVariable(value = "myClass61Id") Long myClass61Id, Model model) 
	{
		MyClass61 myClass61 = this.myClass61Service.findById(myClass61Id);
		model.addAttribute(myClass61);
		return "myclass61/detail";	
	}

	@RequestMapping(value = "/myclass61/edit/{myClass61Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass61Id") Long myClass61Id, Model model) 
	{
		MyClass61 myClass61 = this.myClass61Service.findById(myClass61Id);
		model.addAttribute(myClass61);
		return "myclass61/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass61Validator());	
	}

	@RequestMapping(value = "/myclass61/edit", method = RequestMethod.GET)
	public MyClass61 newMyClass61 (Model model) 
	{
		if(model != null && model.asMap().get("myclass61") == null)
		{
			return new MyClass61();	
		}
		return (MyClass61) model.asMap().get("myclass61");	
	}

	@RequestMapping(value = {"/myclass61/edit", "/myclass61/edit/{myclass61Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass61 MyClass61, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass61/edit";
		}
		
		
		
		this.myClass61Service.save(MyClass61);
		session.setComplete();
		return "redirect:/myclass61/list";	
	}


}
