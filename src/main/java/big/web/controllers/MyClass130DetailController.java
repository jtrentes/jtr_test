package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import big.domain.MyClass130;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass130Validator;
import big.services.MyClass130Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass130.class)
public class MyClass130DetailController
{

	
	@Autowired
	private MyClass130Service myClass130Service;
    

	@RequestMapping(value = "/myclass130/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass130/edit";	
	}

	@RequestMapping(value = "/myclass130/detail/{myClass130Id}")
	public String details (@PathVariable(value = "myClass130Id") Long myClass130Id, Model model) 
	{
		MyClass130 myClass130 = this.myClass130Service.findById(myClass130Id);
		model.addAttribute(myClass130);
		return "myclass130/detail";	
	}

	@RequestMapping(value = "/myclass130/edit/{myClass130Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass130Id") Long myClass130Id, Model model) 
	{
		MyClass130 myClass130 = this.myClass130Service.findById(myClass130Id);
		model.addAttribute(myClass130);
		return "myclass130/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass130Validator());	
	}

	@RequestMapping(value = "/myclass130/edit", method = RequestMethod.GET)
	public MyClass130 newMyClass130 (Model model) 
	{
		if(model != null && model.asMap().get("myclass130") == null)
		{
			return new MyClass130();	
		}
		return (MyClass130) model.asMap().get("myclass130");	
	}

	@RequestMapping(value = {"/myclass130/edit", "/myclass130/edit/{myclass130Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass130 MyClass130, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass130/edit";
		}
		
		
		
		this.myClass130Service.save(MyClass130);
		session.setComplete();
		return "redirect:/myclass130/list";	
	}


}
