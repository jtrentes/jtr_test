package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass94Service;
import big.web.controllers.validator.MyClass94Validator;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import big.domain.MyClass94;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass94.class)
public class MyClass94DetailController
{

	
	@Autowired
	private MyClass94Service myClass94Service;
    

	@RequestMapping(value = "/myclass94/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass94/edit";	
	}

	@RequestMapping(value = "/myclass94/detail/{myClass94Id}")
	public String details (@PathVariable(value = "myClass94Id") Long myClass94Id, Model model) 
	{
		MyClass94 myClass94 = this.myClass94Service.findById(myClass94Id);
		model.addAttribute(myClass94);
		return "myclass94/detail";	
	}

	@RequestMapping(value = "/myclass94/edit/{myClass94Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass94Id") Long myClass94Id, Model model) 
	{
		MyClass94 myClass94 = this.myClass94Service.findById(myClass94Id);
		model.addAttribute(myClass94);
		return "myclass94/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass94Validator());	
	}

	@RequestMapping(value = "/myclass94/edit", method = RequestMethod.GET)
	public MyClass94 newMyClass94 (Model model) 
	{
		if(model != null && model.asMap().get("myclass94") == null)
		{
			return new MyClass94();	
		}
		return (MyClass94) model.asMap().get("myclass94");	
	}

	@RequestMapping(value = {"/myclass94/edit", "/myclass94/edit/{myclass94Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass94 MyClass94, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass94/edit";
		}
		
		
		
		this.myClass94Service.save(MyClass94);
		session.setComplete();
		return "redirect:/myclass94/list";	
	}


}
