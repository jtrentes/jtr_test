package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass50Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.domain.MyClass50;
import big.services.MyClass139Service;
import big.domain.MyClass139;
import org.springframework.validation.BindingResult;
import java.util.List;
import big.services.MyClass50Service;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass50.class)
public class MyClass50DetailController
{

	
	@Autowired
	private MyClass139Service myClass139Service;
	
	@Autowired
	private MyClass50Service myClass50Service;
    

	@RequestMapping(value = "/myclass50/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass50/edit";	
	}

	@RequestMapping(value = "/myclass50/detail/{myClass50Id}")
	public String details (@PathVariable(value = "myClass50Id") Long myClass50Id, Model model) 
	{
		MyClass50 myClass50 = this.myClass50Service.findById(myClass50Id);
		model.addAttribute(myClass50);
		return "myclass50/detail";	
	}

	@RequestMapping(value = "/myclass50/edit/{myClass50Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass50Id") Long myClass50Id, Model model) 
	{
		MyClass50 myClass50 = this.myClass50Service.findById(myClass50Id);
		model.addAttribute(myClass50);
		return "myclass50/edit";	
	}

	@ModelAttribute(value = "myclass139s")
	public List<MyClass139> getMyClass139s () 
	{
		return this.myClass139Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass50Validator());	
	}

	@RequestMapping(value = "/myclass50/edit", method = RequestMethod.GET)
	public MyClass50 newMyClass50 (Model model) 
	{
		if(model != null && model.asMap().get("myclass50") == null)
		{
			return new MyClass50();	
		}
		return (MyClass50) model.asMap().get("myclass50");	
	}

	@RequestMapping(value = {"/myclass50/edit", "/myclass50/edit/{myclass50Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass50 MyClass50, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass50/edit";
		}
		
		if (MyClass50.getMyclass139()!=null && MyClass50.getMyclass139().getId()!=null && MyClass50.getMyclass139().getId() == 0)
			MyClass50.setMyclass139(null);
		
		
		this.myClass50Service.save(MyClass50);
		session.setComplete();
		return "redirect:/myclass50/list";	
	}


}
