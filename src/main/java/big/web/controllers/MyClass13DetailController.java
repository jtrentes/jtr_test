package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass13Validator;
import big.services.MyClass13Service;
import org.springframework.ui.Model;
import big.domain.MyClass13;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass13.class)
public class MyClass13DetailController
{

	
	@Autowired
	private MyClass13Service myClass13Service;
    

	@RequestMapping(value = "/myclass13/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass13/edit";	
	}

	@RequestMapping(value = "/myclass13/detail/{myClass13Id}")
	public String details (@PathVariable(value = "myClass13Id") Long myClass13Id, Model model) 
	{
		MyClass13 myClass13 = this.myClass13Service.findById(myClass13Id);
		model.addAttribute(myClass13);
		return "myclass13/detail";	
	}

	@RequestMapping(value = "/myclass13/edit/{myClass13Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass13Id") Long myClass13Id, Model model) 
	{
		MyClass13 myClass13 = this.myClass13Service.findById(myClass13Id);
		model.addAttribute(myClass13);
		return "myclass13/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass13Validator());	
	}

	@RequestMapping(value = "/myclass13/edit", method = RequestMethod.GET)
	public MyClass13 newMyClass13 (Model model) 
	{
		if(model != null && model.asMap().get("myclass13") == null)
		{
			return new MyClass13();	
		}
		return (MyClass13) model.asMap().get("myclass13");	
	}

	@RequestMapping(value = {"/myclass13/edit", "/myclass13/edit/{myclass13Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass13 MyClass13, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass13/edit";
		}
		
		
		
		this.myClass13Service.save(MyClass13);
		session.setComplete();
		return "redirect:/myclass13/list";	
	}


}
