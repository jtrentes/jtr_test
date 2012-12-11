package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass124Validator;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass140Service;
import org.springframework.validation.BindingResult;
import java.util.List;
import big.domain.MyClass124;
import big.domain.MyClass140;
import big.services.MyClass124Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass124.class)
public class MyClass124DetailController
{

	
	@Autowired
	private MyClass124Service myClass124Service;
	
	@Autowired
	private MyClass140Service myClass140Service;
    

	@RequestMapping(value = "/myclass124/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass124/edit";	
	}

	@RequestMapping(value = "/myclass124/detail/{myClass124Id}")
	public String details (@PathVariable(value = "myClass124Id") Long myClass124Id, Model model) 
	{
		MyClass124 myClass124 = this.myClass124Service.findById(myClass124Id);
		model.addAttribute(myClass124);
		return "myclass124/detail";	
	}

	@RequestMapping(value = "/myclass124/edit/{myClass124Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass124Id") Long myClass124Id, Model model) 
	{
		MyClass124 myClass124 = this.myClass124Service.findById(myClass124Id);
		model.addAttribute(myClass124);
		return "myclass124/edit";	
	}

	@ModelAttribute(value = "myclass140s")
	public List<MyClass140> getMyClass140s () 
	{
		return this.myClass140Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass124Validator());	
	}

	@RequestMapping(value = "/myclass124/edit", method = RequestMethod.GET)
	public MyClass124 newMyClass124 (Model model) 
	{
		if(model != null && model.asMap().get("myclass124") == null)
		{
			return new MyClass124();	
		}
		return (MyClass124) model.asMap().get("myclass124");	
	}

	@RequestMapping(value = {"/myclass124/edit", "/myclass124/edit/{myclass124Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass124 MyClass124, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass124/edit";
		}
		
		if (MyClass124.getMyclass140()!=null && MyClass124.getMyclass140().getId()!=null && MyClass124.getMyclass140().getId() == 0)
			MyClass124.setMyclass140(null);
		
		
		this.myClass124Service.save(MyClass124);
		session.setComplete();
		return "redirect:/myclass124/list";	
	}


}
