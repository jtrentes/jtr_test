package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import java.util.List;
import big.web.controllers.validator.MyClass6Validator;
import big.services.MyClass6Service;
import big.domain.MyClass12;
import org.springframework.validation.BindingResult;
import big.domain.MyClass6;
import org.springframework.ui.Model;
import big.services.MyClass12Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass6.class)
public class MyClass6DetailController
{

	
	@Autowired
	private MyClass12Service myClass12Service;
	
	@Autowired
	private MyClass6Service myClass6Service;
    

	@RequestMapping(value = "/myclass6/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass6/edit";	
	}

	@RequestMapping(value = "/myclass6/detail/{myClass6Id}")
	public String details (@PathVariable(value = "myClass6Id") Long myClass6Id, Model model) 
	{
		MyClass6 myClass6 = this.myClass6Service.findById(myClass6Id);
		model.addAttribute(myClass6);
		return "myclass6/detail";	
	}

	@RequestMapping(value = "/myclass6/edit/{myClass6Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass6Id") Long myClass6Id, Model model) 
	{
		MyClass6 myClass6 = this.myClass6Service.findById(myClass6Id);
		model.addAttribute(myClass6);
		return "myclass6/edit";	
	}

	@ModelAttribute(value = "myclass12s")
	public List<MyClass12> getMyClass12s () 
	{
		return this.myClass12Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass6Validator());	
	}

	@RequestMapping(value = "/myclass6/edit", method = RequestMethod.GET)
	public MyClass6 newMyClass6 (Model model) 
	{
		if(model != null && model.asMap().get("myclass6") == null)
		{
			return new MyClass6();	
		}
		return (MyClass6) model.asMap().get("myclass6");	
	}

	@RequestMapping(value = {"/myclass6/edit", "/myclass6/edit/{myclass6Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass6 MyClass6, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass6/edit";
		}
		
		if (MyClass6.getMyclass12()!=null && MyClass6.getMyclass12().getId()!=null && MyClass6.getMyclass12().getId() == 0)
			MyClass6.setMyclass12(null);
		
		
		this.myClass6Service.save(MyClass6);
		session.setComplete();
		return "redirect:/myclass6/list";	
	}


}
