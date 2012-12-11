package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.services.MyClass142Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass142Validator;
import org.springframework.validation.BindingResult;
import big.domain.MyClass142;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass142.class)
public class MyClass142DetailController
{

	
	@Autowired
	private MyClass142Service myClass142Service;
    

	@RequestMapping(value = "/myclass142/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass142/edit";	
	}

	@RequestMapping(value = "/myclass142/detail/{myClass142Id}")
	public String details (@PathVariable(value = "myClass142Id") Long myClass142Id, Model model) 
	{
		MyClass142 myClass142 = this.myClass142Service.findById(myClass142Id);
		model.addAttribute(myClass142);
		return "myclass142/detail";	
	}

	@RequestMapping(value = "/myclass142/edit/{myClass142Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass142Id") Long myClass142Id, Model model) 
	{
		MyClass142 myClass142 = this.myClass142Service.findById(myClass142Id);
		model.addAttribute(myClass142);
		return "myclass142/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass142Validator());	
	}

	@RequestMapping(value = "/myclass142/edit", method = RequestMethod.GET)
	public MyClass142 newMyClass142 (Model model) 
	{
		if(model != null && model.asMap().get("myclass142") == null)
		{
			return new MyClass142();	
		}
		return (MyClass142) model.asMap().get("myclass142");	
	}

	@RequestMapping(value = {"/myclass142/edit", "/myclass142/edit/{myclass142Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass142 MyClass142, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass142/edit";
		}
		
		
		
		this.myClass142Service.save(MyClass142);
		session.setComplete();
		return "redirect:/myclass142/list";	
	}


}
