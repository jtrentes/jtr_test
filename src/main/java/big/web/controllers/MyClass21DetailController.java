package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.services.MyClass21Service;
import org.springframework.ui.Model;
import big.domain.MyClass21;
import big.web.controllers.validator.MyClass21Validator;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass21.class)
public class MyClass21DetailController
{

	
	@Autowired
	private MyClass21Service myClass21Service;
    

	@RequestMapping(value = "/myclass21/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass21/edit";	
	}

	@RequestMapping(value = "/myclass21/detail/{myClass21Id}")
	public String details (@PathVariable(value = "myClass21Id") Long myClass21Id, Model model) 
	{
		MyClass21 myClass21 = this.myClass21Service.findById(myClass21Id);
		model.addAttribute(myClass21);
		return "myclass21/detail";	
	}

	@RequestMapping(value = "/myclass21/edit/{myClass21Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass21Id") Long myClass21Id, Model model) 
	{
		MyClass21 myClass21 = this.myClass21Service.findById(myClass21Id);
		model.addAttribute(myClass21);
		return "myclass21/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass21Validator());	
	}

	@RequestMapping(value = "/myclass21/edit", method = RequestMethod.GET)
	public MyClass21 newMyClass21 (Model model) 
	{
		if(model != null && model.asMap().get("myclass21") == null)
		{
			return new MyClass21();	
		}
		return (MyClass21) model.asMap().get("myclass21");	
	}

	@RequestMapping(value = {"/myclass21/edit", "/myclass21/edit/{myclass21Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass21 MyClass21, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass21/edit";
		}
		
		
		
		this.myClass21Service.save(MyClass21);
		session.setComplete();
		return "redirect:/myclass21/list";	
	}


}
