package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import big.services.MyClass143Service;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass143;
import big.web.controllers.validator.MyClass143Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass143.class)
public class MyClass143DetailController
{

	
	@Autowired
	private MyClass143Service myClass143Service;
    

	@RequestMapping(value = "/myclass143/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass143/edit";	
	}

	@RequestMapping(value = "/myclass143/detail/{myClass143Id}")
	public String details (@PathVariable(value = "myClass143Id") Long myClass143Id, Model model) 
	{
		MyClass143 myClass143 = this.myClass143Service.findById(myClass143Id);
		model.addAttribute(myClass143);
		return "myclass143/detail";	
	}

	@RequestMapping(value = "/myclass143/edit/{myClass143Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass143Id") Long myClass143Id, Model model) 
	{
		MyClass143 myClass143 = this.myClass143Service.findById(myClass143Id);
		model.addAttribute(myClass143);
		return "myclass143/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass143Validator());	
	}

	@RequestMapping(value = "/myclass143/edit", method = RequestMethod.GET)
	public MyClass143 newMyClass143 (Model model) 
	{
		if(model != null && model.asMap().get("myclass143") == null)
		{
			return new MyClass143();	
		}
		return (MyClass143) model.asMap().get("myclass143");	
	}

	@RequestMapping(value = {"/myclass143/edit", "/myclass143/edit/{myclass143Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass143 MyClass143, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass143/edit";
		}
		
		
		
		this.myClass143Service.save(MyClass143);
		session.setComplete();
		return "redirect:/myclass143/list";	
	}


}
