package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass56Validator;
import big.services.MyClass56Service;
import big.domain.MyClass56;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass56.class)
public class MyClass56DetailController
{

	
	@Autowired
	private MyClass56Service myClass56Service;
    

	@RequestMapping(value = "/myclass56/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass56/edit";	
	}

	@RequestMapping(value = "/myclass56/detail/{myClass56Id}")
	public String details (@PathVariable(value = "myClass56Id") Long myClass56Id, Model model) 
	{
		MyClass56 myClass56 = this.myClass56Service.findById(myClass56Id);
		model.addAttribute(myClass56);
		return "myclass56/detail";	
	}

	@RequestMapping(value = "/myclass56/edit/{myClass56Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass56Id") Long myClass56Id, Model model) 
	{
		MyClass56 myClass56 = this.myClass56Service.findById(myClass56Id);
		model.addAttribute(myClass56);
		return "myclass56/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass56Validator());	
	}

	@RequestMapping(value = "/myclass56/edit", method = RequestMethod.GET)
	public MyClass56 newMyClass56 (Model model) 
	{
		if(model != null && model.asMap().get("myclass56") == null)
		{
			return new MyClass56();	
		}
		return (MyClass56) model.asMap().get("myclass56");	
	}

	@RequestMapping(value = {"/myclass56/edit", "/myclass56/edit/{myclass56Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass56 MyClass56, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass56/edit";
		}
		
		
		
		this.myClass56Service.save(MyClass56);
		session.setComplete();
		return "redirect:/myclass56/list";	
	}


}
