package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass154Validator;
import big.domain.MyClass154;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.services.MyClass154Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass154.class)
public class MyClass154DetailController
{

	
	@Autowired
	private MyClass154Service myClass154Service;
    

	@RequestMapping(value = "/myclass154/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass154/edit";	
	}

	@RequestMapping(value = "/myclass154/detail/{myClass154Id}")
	public String details (@PathVariable(value = "myClass154Id") Long myClass154Id, Model model) 
	{
		MyClass154 myClass154 = this.myClass154Service.findById(myClass154Id);
		model.addAttribute(myClass154);
		return "myclass154/detail";	
	}

	@RequestMapping(value = "/myclass154/edit/{myClass154Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass154Id") Long myClass154Id, Model model) 
	{
		MyClass154 myClass154 = this.myClass154Service.findById(myClass154Id);
		model.addAttribute(myClass154);
		return "myclass154/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass154Validator());	
	}

	@RequestMapping(value = "/myclass154/edit", method = RequestMethod.GET)
	public MyClass154 newMyClass154 (Model model) 
	{
		if(model != null && model.asMap().get("myclass154") == null)
		{
			return new MyClass154();	
		}
		return (MyClass154) model.asMap().get("myclass154");	
	}

	@RequestMapping(value = {"/myclass154/edit", "/myclass154/edit/{myclass154Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass154 MyClass154, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass154/edit";
		}
		
		
		
		this.myClass154Service.save(MyClass154);
		session.setComplete();
		return "redirect:/myclass154/list";	
	}


}
