package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass163Service;
import java.util.List;
import big.domain.MyClass81;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass163;
import big.services.MyClass81Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass81Validator;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass81.class)
public class MyClass81DetailController
{

	
	@Autowired
	private MyClass163Service myClass163Service;
	
	@Autowired
	private MyClass81Service myClass81Service;
    

	@RequestMapping(value = "/myclass81/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass81/edit";	
	}

	@RequestMapping(value = "/myclass81/detail/{myClass81Id}")
	public String details (@PathVariable(value = "myClass81Id") Long myClass81Id, Model model) 
	{
		MyClass81 myClass81 = this.myClass81Service.findById(myClass81Id);
		model.addAttribute(myClass81);
		return "myclass81/detail";	
	}

	@RequestMapping(value = "/myclass81/edit/{myClass81Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass81Id") Long myClass81Id, Model model) 
	{
		MyClass81 myClass81 = this.myClass81Service.findById(myClass81Id);
		model.addAttribute(myClass81);
		return "myclass81/edit";	
	}

	@ModelAttribute(value = "myclass163s")
	public List<MyClass163> getMyClass163s () 
	{
		return this.myClass163Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass81Validator());	
	}

	@RequestMapping(value = "/myclass81/edit", method = RequestMethod.GET)
	public MyClass81 newMyClass81 (Model model) 
	{
		if(model != null && model.asMap().get("myclass81") == null)
		{
			return new MyClass81();	
		}
		return (MyClass81) model.asMap().get("myclass81");	
	}

	@RequestMapping(value = {"/myclass81/edit", "/myclass81/edit/{myclass81Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass81 MyClass81, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass81/edit";
		}
		
		if (MyClass81.getMyclass163()!=null && MyClass81.getMyclass163().getId()!=null && MyClass81.getMyclass163().getId() == 0)
			MyClass81.setMyclass163(null);
		
		
		this.myClass81Service.save(MyClass81);
		session.setComplete();
		return "redirect:/myclass81/list";	
	}


}
