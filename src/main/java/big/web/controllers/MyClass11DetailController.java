package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass11Service;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass11Validator;
import org.springframework.validation.BindingResult;
import big.domain.MyClass11;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass11.class)
public class MyClass11DetailController
{

	
	@Autowired
	private MyClass11Service myClass11Service;
    

	@RequestMapping(value = "/myclass11/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass11/edit";	
	}

	@RequestMapping(value = "/myclass11/detail/{myClass11Id}")
	public String details (@PathVariable(value = "myClass11Id") Long myClass11Id, Model model) 
	{
		MyClass11 myClass11 = this.myClass11Service.findById(myClass11Id);
		model.addAttribute(myClass11);
		return "myclass11/detail";	
	}

	@RequestMapping(value = "/myclass11/edit/{myClass11Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass11Id") Long myClass11Id, Model model) 
	{
		MyClass11 myClass11 = this.myClass11Service.findById(myClass11Id);
		model.addAttribute(myClass11);
		return "myclass11/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass11Validator());	
	}

	@RequestMapping(value = "/myclass11/edit", method = RequestMethod.GET)
	public MyClass11 newMyClass11 (Model model) 
	{
		if(model != null && model.asMap().get("myclass11") == null)
		{
			return new MyClass11();	
		}
		return (MyClass11) model.asMap().get("myclass11");	
	}

	@RequestMapping(value = {"/myclass11/edit", "/myclass11/edit/{myclass11Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass11 MyClass11, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass11/edit";
		}
		
		
		
		this.myClass11Service.save(MyClass11);
		session.setComplete();
		return "redirect:/myclass11/list";	
	}


}
