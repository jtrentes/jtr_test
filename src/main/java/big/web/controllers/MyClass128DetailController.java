package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.services.MyClass128Service;
import big.domain.MyClass128;
import big.web.controllers.validator.MyClass128Validator;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass128.class)
public class MyClass128DetailController
{

	
	@Autowired
	private MyClass128Service myClass128Service;
    

	@RequestMapping(value = "/myclass128/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass128/edit";	
	}

	@RequestMapping(value = "/myclass128/detail/{myClass128Id}")
	public String details (@PathVariable(value = "myClass128Id") Long myClass128Id, Model model) 
	{
		MyClass128 myClass128 = this.myClass128Service.findById(myClass128Id);
		model.addAttribute(myClass128);
		return "myclass128/detail";	
	}

	@RequestMapping(value = "/myclass128/edit/{myClass128Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass128Id") Long myClass128Id, Model model) 
	{
		MyClass128 myClass128 = this.myClass128Service.findById(myClass128Id);
		model.addAttribute(myClass128);
		return "myclass128/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass128Validator());	
	}

	@RequestMapping(value = "/myclass128/edit", method = RequestMethod.GET)
	public MyClass128 newMyClass128 (Model model) 
	{
		if(model != null && model.asMap().get("myclass128") == null)
		{
			return new MyClass128();	
		}
		return (MyClass128) model.asMap().get("myclass128");	
	}

	@RequestMapping(value = {"/myclass128/edit", "/myclass128/edit/{myclass128Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass128 MyClass128, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass128/edit";
		}
		
		
		
		this.myClass128Service.save(MyClass128);
		session.setComplete();
		return "redirect:/myclass128/list";	
	}


}
