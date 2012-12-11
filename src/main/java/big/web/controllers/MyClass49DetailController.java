package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass49Service;
import big.domain.MyClass49;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass49Validator;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass49.class)
public class MyClass49DetailController
{

	
	@Autowired
	private MyClass49Service myClass49Service;
    

	@RequestMapping(value = "/myclass49/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass49/edit";	
	}

	@RequestMapping(value = "/myclass49/detail/{myClass49Id}")
	public String details (@PathVariable(value = "myClass49Id") Long myClass49Id, Model model) 
	{
		MyClass49 myClass49 = this.myClass49Service.findById(myClass49Id);
		model.addAttribute(myClass49);
		return "myclass49/detail";	
	}

	@RequestMapping(value = "/myclass49/edit/{myClass49Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass49Id") Long myClass49Id, Model model) 
	{
		MyClass49 myClass49 = this.myClass49Service.findById(myClass49Id);
		model.addAttribute(myClass49);
		return "myclass49/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass49Validator());	
	}

	@RequestMapping(value = "/myclass49/edit", method = RequestMethod.GET)
	public MyClass49 newMyClass49 (Model model) 
	{
		if(model != null && model.asMap().get("myclass49") == null)
		{
			return new MyClass49();	
		}
		return (MyClass49) model.asMap().get("myclass49");	
	}

	@RequestMapping(value = {"/myclass49/edit", "/myclass49/edit/{myclass49Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass49 MyClass49, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass49/edit";
		}
		
		
		
		this.myClass49Service.save(MyClass49);
		session.setComplete();
		return "redirect:/myclass49/list";	
	}


}
