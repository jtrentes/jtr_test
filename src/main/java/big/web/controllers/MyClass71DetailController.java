package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass71Validator;
import big.domain.MyClass71;
import java.util.List;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass78;
import big.services.MyClass71Service;
import big.services.MyClass78Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass71.class)
public class MyClass71DetailController
{

	
	@Autowired
	private MyClass71Service myClass71Service;
	
	@Autowired
	private MyClass78Service myClass78Service;
    

	@RequestMapping(value = "/myclass71/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass71/edit";	
	}

	@RequestMapping(value = "/myclass71/detail/{myClass71Id}")
	public String details (@PathVariable(value = "myClass71Id") Long myClass71Id, Model model) 
	{
		MyClass71 myClass71 = this.myClass71Service.findById(myClass71Id);
		model.addAttribute(myClass71);
		return "myclass71/detail";	
	}

	@RequestMapping(value = "/myclass71/edit/{myClass71Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass71Id") Long myClass71Id, Model model) 
	{
		MyClass71 myClass71 = this.myClass71Service.findById(myClass71Id);
		model.addAttribute(myClass71);
		return "myclass71/edit";	
	}

	@ModelAttribute(value = "myclass78s")
	public List<MyClass78> getMyClass78s () 
	{
		return this.myClass78Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass71Validator());	
	}

	@RequestMapping(value = "/myclass71/edit", method = RequestMethod.GET)
	public MyClass71 newMyClass71 (Model model) 
	{
		if(model != null && model.asMap().get("myclass71") == null)
		{
			return new MyClass71();	
		}
		return (MyClass71) model.asMap().get("myclass71");	
	}

	@RequestMapping(value = {"/myclass71/edit", "/myclass71/edit/{myclass71Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass71 MyClass71, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass71/edit";
		}
		
		if (MyClass71.getMyclass78()!=null && MyClass71.getMyclass78().getId()!=null && MyClass71.getMyclass78().getId() == 0)
			MyClass71.setMyclass78(null);
		
		
		this.myClass71Service.save(MyClass71);
		session.setComplete();
		return "redirect:/myclass71/list";	
	}


}
