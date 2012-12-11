package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import big.services.MyClass74Service;
import big.domain.MyClass117;
import big.web.controllers.validator.MyClass74Validator;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass74;
import big.services.MyClass117Service;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass74.class)
public class MyClass74DetailController
{

	
	@Autowired
	private MyClass117Service myClass117Service;
	
	@Autowired
	private MyClass74Service myClass74Service;
    

	@RequestMapping(value = "/myclass74/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass74/edit";	
	}

	@RequestMapping(value = "/myclass74/detail/{myClass74Id}")
	public String details (@PathVariable(value = "myClass74Id") Long myClass74Id, Model model) 
	{
		MyClass74 myClass74 = this.myClass74Service.findById(myClass74Id);
		model.addAttribute(myClass74);
		return "myclass74/detail";	
	}

	@RequestMapping(value = "/myclass74/edit/{myClass74Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass74Id") Long myClass74Id, Model model) 
	{
		MyClass74 myClass74 = this.myClass74Service.findById(myClass74Id);
		model.addAttribute(myClass74);
		return "myclass74/edit";	
	}

	@ModelAttribute(value = "myclass117s")
	public List<MyClass117> getMyClass117s () 
	{
		return this.myClass117Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass74Validator());	
	}

	@RequestMapping(value = "/myclass74/edit", method = RequestMethod.GET)
	public MyClass74 newMyClass74 (Model model) 
	{
		if(model != null && model.asMap().get("myclass74") == null)
		{
			return new MyClass74();	
		}
		return (MyClass74) model.asMap().get("myclass74");	
	}

	@RequestMapping(value = {"/myclass74/edit", "/myclass74/edit/{myclass74Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass74 MyClass74, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass74/edit";
		}
		
		if (MyClass74.getMyclass117()!=null && MyClass74.getMyclass117().getId()!=null && MyClass74.getMyclass117().getId() == 0)
			MyClass74.setMyclass117(null);
		
		
		this.myClass74Service.save(MyClass74);
		session.setComplete();
		return "redirect:/myclass74/list";	
	}


}
