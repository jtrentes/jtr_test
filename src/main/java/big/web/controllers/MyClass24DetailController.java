package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass24;
import big.services.MyClass6Service;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass24Validator;
import java.util.List;
import big.domain.MyClass6;
import big.services.MyClass24Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass24.class)
public class MyClass24DetailController
{

	
	@Autowired
	private MyClass24Service myClass24Service;
	
	@Autowired
	private MyClass6Service myClass6Service;
    

	@RequestMapping(value = "/myclass24/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass24/edit";	
	}

	@RequestMapping(value = "/myclass24/detail/{myClass24Id}")
	public String details (@PathVariable(value = "myClass24Id") Long myClass24Id, Model model) 
	{
		MyClass24 myClass24 = this.myClass24Service.findById(myClass24Id);
		model.addAttribute(myClass24);
		return "myclass24/detail";	
	}

	@RequestMapping(value = "/myclass24/edit/{myClass24Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass24Id") Long myClass24Id, Model model) 
	{
		MyClass24 myClass24 = this.myClass24Service.findById(myClass24Id);
		model.addAttribute(myClass24);
		return "myclass24/edit";	
	}

	@ModelAttribute(value = "myclass6s")
	public List<MyClass6> getMyClass6s () 
	{
		return this.myClass6Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass24Validator());	
	}

	@RequestMapping(value = "/myclass24/edit", method = RequestMethod.GET)
	public MyClass24 newMyClass24 (Model model) 
	{
		if(model != null && model.asMap().get("myclass24") == null)
		{
			return new MyClass24();	
		}
		return (MyClass24) model.asMap().get("myclass24");	
	}

	@RequestMapping(value = {"/myclass24/edit", "/myclass24/edit/{myclass24Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass24 MyClass24, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass24/edit";
		}
		
		if (MyClass24.getMyclass6()!=null && MyClass24.getMyclass6().getId()!=null && MyClass24.getMyclass6().getId() == 0)
			MyClass24.setMyclass6(null);
		
		
		this.myClass24Service.save(MyClass24);
		session.setComplete();
		return "redirect:/myclass24/list";	
	}


}
