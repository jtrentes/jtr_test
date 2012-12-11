package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass79Validator;
import org.springframework.validation.BindingResult;
import big.domain.MyClass79;
import big.services.MyClass79Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass79.class)
public class MyClass79DetailController
{

	
	@Autowired
	private MyClass79Service myClass79Service;
    

	@RequestMapping(value = "/myclass79/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass79/edit";	
	}

	@RequestMapping(value = "/myclass79/detail/{myClass79Id}")
	public String details (@PathVariable(value = "myClass79Id") Long myClass79Id, Model model) 
	{
		MyClass79 myClass79 = this.myClass79Service.findById(myClass79Id);
		model.addAttribute(myClass79);
		return "myclass79/detail";	
	}

	@RequestMapping(value = "/myclass79/edit/{myClass79Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass79Id") Long myClass79Id, Model model) 
	{
		MyClass79 myClass79 = this.myClass79Service.findById(myClass79Id);
		model.addAttribute(myClass79);
		return "myclass79/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass79Validator());	
	}

	@RequestMapping(value = "/myclass79/edit", method = RequestMethod.GET)
	public MyClass79 newMyClass79 (Model model) 
	{
		if(model != null && model.asMap().get("myclass79") == null)
		{
			return new MyClass79();	
		}
		return (MyClass79) model.asMap().get("myclass79");	
	}

	@RequestMapping(value = {"/myclass79/edit", "/myclass79/edit/{myclass79Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass79 MyClass79, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass79/edit";
		}
		
		
		
		this.myClass79Service.save(MyClass79);
		session.setComplete();
		return "redirect:/myclass79/list";	
	}


}
