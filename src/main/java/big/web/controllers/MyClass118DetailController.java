package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import big.domain.MyClass118;
import big.services.MyClass118Service;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass118Validator;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass118.class)
public class MyClass118DetailController
{

	
	@Autowired
	private MyClass118Service myClass118Service;
    

	@RequestMapping(value = "/myclass118/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass118/edit";	
	}

	@RequestMapping(value = "/myclass118/detail/{myClass118Id}")
	public String details (@PathVariable(value = "myClass118Id") Long myClass118Id, Model model) 
	{
		MyClass118 myClass118 = this.myClass118Service.findById(myClass118Id);
		model.addAttribute(myClass118);
		return "myclass118/detail";	
	}

	@RequestMapping(value = "/myclass118/edit/{myClass118Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass118Id") Long myClass118Id, Model model) 
	{
		MyClass118 myClass118 = this.myClass118Service.findById(myClass118Id);
		model.addAttribute(myClass118);
		return "myclass118/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass118Validator());	
	}

	@RequestMapping(value = "/myclass118/edit", method = RequestMethod.GET)
	public MyClass118 newMyClass118 (Model model) 
	{
		if(model != null && model.asMap().get("myclass118") == null)
		{
			return new MyClass118();	
		}
		return (MyClass118) model.asMap().get("myclass118");	
	}

	@RequestMapping(value = {"/myclass118/edit", "/myclass118/edit/{myclass118Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass118 MyClass118, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass118/edit";
		}
		
		
		
		this.myClass118Service.save(MyClass118);
		session.setComplete();
		return "redirect:/myclass118/list";	
	}


}
