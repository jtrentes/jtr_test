package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass78Validator;
import big.domain.MyClass74;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import big.domain.MyClass78;
import big.services.MyClass74Service;
import big.services.MyClass78Service;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass78.class)
public class MyClass78DetailController
{

	
	@Autowired
	private MyClass74Service myClass74Service;
	
	@Autowired
	private MyClass78Service myClass78Service;
    

	@RequestMapping(value = "/myclass78/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass78/edit";	
	}

	@RequestMapping(value = "/myclass78/detail/{myClass78Id}")
	public String details (@PathVariable(value = "myClass78Id") Long myClass78Id, Model model) 
	{
		MyClass78 myClass78 = this.myClass78Service.findById(myClass78Id);
		model.addAttribute(myClass78);
		return "myclass78/detail";	
	}

	@RequestMapping(value = "/myclass78/edit/{myClass78Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass78Id") Long myClass78Id, Model model) 
	{
		MyClass78 myClass78 = this.myClass78Service.findById(myClass78Id);
		model.addAttribute(myClass78);
		return "myclass78/edit";	
	}

	@ModelAttribute(value = "myclass74s")
	public List<MyClass74> getMyClass74s () 
	{
		return this.myClass74Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass78Validator());	
	}

	@RequestMapping(value = "/myclass78/edit", method = RequestMethod.GET)
	public MyClass78 newMyClass78 (Model model) 
	{
		if(model != null && model.asMap().get("myclass78") == null)
		{
			return new MyClass78();	
		}
		return (MyClass78) model.asMap().get("myclass78");	
	}

	@RequestMapping(value = {"/myclass78/edit", "/myclass78/edit/{myclass78Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass78 MyClass78, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass78/edit";
		}
		
		if (MyClass78.getMyclass74()!=null && MyClass78.getMyclass74().getId()!=null && MyClass78.getMyclass74().getId() == 0)
			MyClass78.setMyclass74(null);
		
		
		this.myClass78Service.save(MyClass78);
		session.setComplete();
		return "redirect:/myclass78/list";	
	}


}
