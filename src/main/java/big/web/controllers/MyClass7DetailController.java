package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass69Service;
import org.springframework.ui.Model;
import big.domain.MyClass69;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass7Validator;
import big.services.MyClass7Service;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass7;
import java.util.List;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass7.class)
public class MyClass7DetailController
{

	
	@Autowired
	private MyClass69Service myClass69Service;
	
	@Autowired
	private MyClass7Service myClass7Service;
    

	@RequestMapping(value = "/myclass7/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass7/edit";	
	}

	@RequestMapping(value = "/myclass7/detail/{myClass7Id}")
	public String details (@PathVariable(value = "myClass7Id") Long myClass7Id, Model model) 
	{
		MyClass7 myClass7 = this.myClass7Service.findById(myClass7Id);
		model.addAttribute(myClass7);
		return "myclass7/detail";	
	}

	@RequestMapping(value = "/myclass7/edit/{myClass7Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass7Id") Long myClass7Id, Model model) 
	{
		MyClass7 myClass7 = this.myClass7Service.findById(myClass7Id);
		model.addAttribute(myClass7);
		return "myclass7/edit";	
	}

	@ModelAttribute(value = "myclass69s")
	public List<MyClass69> getMyClass69s () 
	{
		return this.myClass69Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass7Validator());	
	}

	@RequestMapping(value = "/myclass7/edit", method = RequestMethod.GET)
	public MyClass7 newMyClass7 (Model model) 
	{
		if(model != null && model.asMap().get("myclass7") == null)
		{
			return new MyClass7();	
		}
		return (MyClass7) model.asMap().get("myclass7");	
	}

	@RequestMapping(value = {"/myclass7/edit", "/myclass7/edit/{myclass7Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass7 MyClass7, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass7/edit";
		}
		
		if (MyClass7.getMyclass69()!=null && MyClass7.getMyclass69().getId()!=null && MyClass7.getMyclass69().getId() == 0)
			MyClass7.setMyclass69(null);
		
		
		this.myClass7Service.save(MyClass7);
		session.setComplete();
		return "redirect:/myclass7/list";	
	}


}
