package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass103;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass103Validator;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import big.services.MyClass103Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass103.class)
public class MyClass103DetailController
{

	
	@Autowired
	private MyClass103Service myClass103Service;
    

	@RequestMapping(value = "/myclass103/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass103/edit";	
	}

	@RequestMapping(value = "/myclass103/detail/{myClass103Id}")
	public String details (@PathVariable(value = "myClass103Id") Long myClass103Id, Model model) 
	{
		MyClass103 myClass103 = this.myClass103Service.findById(myClass103Id);
		model.addAttribute(myClass103);
		return "myclass103/detail";	
	}

	@RequestMapping(value = "/myclass103/edit/{myClass103Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass103Id") Long myClass103Id, Model model) 
	{
		MyClass103 myClass103 = this.myClass103Service.findById(myClass103Id);
		model.addAttribute(myClass103);
		return "myclass103/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass103Validator());	
	}

	@RequestMapping(value = "/myclass103/edit", method = RequestMethod.GET)
	public MyClass103 newMyClass103 (Model model) 
	{
		if(model != null && model.asMap().get("myclass103") == null)
		{
			return new MyClass103();	
		}
		return (MyClass103) model.asMap().get("myclass103");	
	}

	@RequestMapping(value = {"/myclass103/edit", "/myclass103/edit/{myclass103Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass103 MyClass103, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass103/edit";
		}
		
		
		
		this.myClass103Service.save(MyClass103);
		session.setComplete();
		return "redirect:/myclass103/list";	
	}


}
