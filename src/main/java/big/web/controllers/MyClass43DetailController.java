package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import big.services.MyClass43Service;
import big.web.controllers.validator.MyClass43Validator;
import big.domain.MyClass43;
import big.domain.MyClass34;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass34Service;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass43.class)
public class MyClass43DetailController
{

	
	@Autowired
	private MyClass34Service myClass34Service;
	
	@Autowired
	private MyClass43Service myClass43Service;
    

	@RequestMapping(value = "/myclass43/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass43/edit";	
	}

	@RequestMapping(value = "/myclass43/detail/{myClass43Id}")
	public String details (@PathVariable(value = "myClass43Id") Long myClass43Id, Model model) 
	{
		MyClass43 myClass43 = this.myClass43Service.findById(myClass43Id);
		model.addAttribute(myClass43);
		return "myclass43/detail";	
	}

	@RequestMapping(value = "/myclass43/edit/{myClass43Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass43Id") Long myClass43Id, Model model) 
	{
		MyClass43 myClass43 = this.myClass43Service.findById(myClass43Id);
		model.addAttribute(myClass43);
		return "myclass43/edit";	
	}

	@ModelAttribute(value = "myclass34s")
	public List<MyClass34> getMyClass34s () 
	{
		return this.myClass34Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass43Validator());	
	}

	@RequestMapping(value = "/myclass43/edit", method = RequestMethod.GET)
	public MyClass43 newMyClass43 (Model model) 
	{
		if(model != null && model.asMap().get("myclass43") == null)
		{
			return new MyClass43();	
		}
		return (MyClass43) model.asMap().get("myclass43");	
	}

	@RequestMapping(value = {"/myclass43/edit", "/myclass43/edit/{myclass43Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass43 MyClass43, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass43/edit";
		}
		
		if (MyClass43.getMyclass34()!=null && MyClass43.getMyclass34().getId()!=null && MyClass43.getMyclass34().getId() == 0)
			MyClass43.setMyclass34(null);
		
		
		this.myClass43Service.save(MyClass43);
		session.setComplete();
		return "redirect:/myclass43/list";	
	}


}
