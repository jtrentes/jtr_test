package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass72;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass72Service;
import big.web.controllers.validator.MyClass72Validator;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass72.class)
public class MyClass72DetailController
{

	
	@Autowired
	private MyClass72Service myClass72Service;
    

	@RequestMapping(value = "/myclass72/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass72/edit";	
	}

	@RequestMapping(value = "/myclass72/detail/{myClass72Id}")
	public String details (@PathVariable(value = "myClass72Id") Long myClass72Id, Model model) 
	{
		MyClass72 myClass72 = this.myClass72Service.findById(myClass72Id);
		model.addAttribute(myClass72);
		return "myclass72/detail";	
	}

	@RequestMapping(value = "/myclass72/edit/{myClass72Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass72Id") Long myClass72Id, Model model) 
	{
		MyClass72 myClass72 = this.myClass72Service.findById(myClass72Id);
		model.addAttribute(myClass72);
		return "myclass72/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass72Validator());	
	}

	@RequestMapping(value = "/myclass72/edit", method = RequestMethod.GET)
	public MyClass72 newMyClass72 (Model model) 
	{
		if(model != null && model.asMap().get("myclass72") == null)
		{
			return new MyClass72();	
		}
		return (MyClass72) model.asMap().get("myclass72");	
	}

	@RequestMapping(value = {"/myclass72/edit", "/myclass72/edit/{myclass72Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass72 MyClass72, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass72/edit";
		}
		
		
		
		this.myClass72Service.save(MyClass72);
		session.setComplete();
		return "redirect:/myclass72/list";	
	}


}
