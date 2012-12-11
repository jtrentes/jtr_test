package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass93Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass93Validator;
import org.springframework.ui.Model;
import big.domain.MyClass93;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
@SessionAttributes(types = MyClass93.class)
public class MyClass93DetailController
{

	
	@Autowired
	private MyClass93Service myClass93Service;
    

	@RequestMapping(value = "/myclass93/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass93/edit";	
	}

	@RequestMapping(value = "/myclass93/detail/{myClass93Id}")
	public String details (@PathVariable(value = "myClass93Id") Long myClass93Id, Model model) 
	{
		MyClass93 myClass93 = this.myClass93Service.findById(myClass93Id);
		model.addAttribute(myClass93);
		return "myclass93/detail";	
	}

	@RequestMapping(value = "/myclass93/edit/{myClass93Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass93Id") Long myClass93Id, Model model) 
	{
		MyClass93 myClass93 = this.myClass93Service.findById(myClass93Id);
		model.addAttribute(myClass93);
		return "myclass93/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass93Validator());	
	}

	@RequestMapping(value = "/myclass93/edit", method = RequestMethod.GET)
	public MyClass93 newMyClass93 (Model model) 
	{
		if(model != null && model.asMap().get("myclass93") == null)
		{
			return new MyClass93();	
		}
		return (MyClass93) model.asMap().get("myclass93");	
	}

	@RequestMapping(value = {"/myclass93/edit", "/myclass93/edit/{myclass93Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass93 MyClass93, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass93/edit";
		}
		
		
		
		this.myClass93Service.save(MyClass93);
		session.setComplete();
		return "redirect:/myclass93/list";	
	}


}
