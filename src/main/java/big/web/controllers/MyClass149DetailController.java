package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass149;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass149Service;
import big.web.controllers.validator.MyClass149Validator;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass149.class)
public class MyClass149DetailController
{

	
	@Autowired
	private MyClass149Service myClass149Service;
    

	@RequestMapping(value = "/myclass149/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass149/edit";	
	}

	@RequestMapping(value = "/myclass149/detail/{myClass149Id}")
	public String details (@PathVariable(value = "myClass149Id") Long myClass149Id, Model model) 
	{
		MyClass149 myClass149 = this.myClass149Service.findById(myClass149Id);
		model.addAttribute(myClass149);
		return "myclass149/detail";	
	}

	@RequestMapping(value = "/myclass149/edit/{myClass149Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass149Id") Long myClass149Id, Model model) 
	{
		MyClass149 myClass149 = this.myClass149Service.findById(myClass149Id);
		model.addAttribute(myClass149);
		return "myclass149/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass149Validator());	
	}

	@RequestMapping(value = "/myclass149/edit", method = RequestMethod.GET)
	public MyClass149 newMyClass149 (Model model) 
	{
		if(model != null && model.asMap().get("myclass149") == null)
		{
			return new MyClass149();	
		}
		return (MyClass149) model.asMap().get("myclass149");	
	}

	@RequestMapping(value = {"/myclass149/edit", "/myclass149/edit/{myclass149Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass149 MyClass149, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass149/edit";
		}
		
		
		
		this.myClass149Service.save(MyClass149);
		session.setComplete();
		return "redirect:/myclass149/list";	
	}


}
