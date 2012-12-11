package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass115Service;
import big.services.MyClass50Service;
import big.domain.MyClass50;
import big.web.controllers.validator.MyClass115Validator;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass115;
import org.springframework.web.bind.WebDataBinder;
import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass115.class)
public class MyClass115DetailController
{

	
	@Autowired
	private MyClass115Service myClass115Service;
	
	@Autowired
	private MyClass50Service myClass50Service;
    

	@RequestMapping(value = "/myclass115/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass115/edit";	
	}

	@RequestMapping(value = "/myclass115/detail/{myClass115Id}")
	public String details (@PathVariable(value = "myClass115Id") Long myClass115Id, Model model) 
	{
		MyClass115 myClass115 = this.myClass115Service.findById(myClass115Id);
		model.addAttribute(myClass115);
		return "myclass115/detail";	
	}

	@RequestMapping(value = "/myclass115/edit/{myClass115Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass115Id") Long myClass115Id, Model model) 
	{
		MyClass115 myClass115 = this.myClass115Service.findById(myClass115Id);
		model.addAttribute(myClass115);
		return "myclass115/edit";	
	}

	@ModelAttribute(value = "myclass50s")
	public List<MyClass50> getMyClass50s () 
	{
		return this.myClass50Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass115Validator());	
	}

	@RequestMapping(value = "/myclass115/edit", method = RequestMethod.GET)
	public MyClass115 newMyClass115 (Model model) 
	{
		if(model != null && model.asMap().get("myclass115") == null)
		{
			return new MyClass115();	
		}
		return (MyClass115) model.asMap().get("myclass115");	
	}

	@RequestMapping(value = {"/myclass115/edit", "/myclass115/edit/{myclass115Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass115 MyClass115, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass115/edit";
		}
		
		if (MyClass115.getMyclass50()!=null && MyClass115.getMyclass50().getId()!=null && MyClass115.getMyclass50().getId() == 0)
			MyClass115.setMyclass50(null);
		
		
		this.myClass115Service.save(MyClass115);
		session.setComplete();
		return "redirect:/myclass115/list";	
	}


}
