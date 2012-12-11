package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass116Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass116Validator;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass116;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass116.class)
public class MyClass116DetailController
{

	
	@Autowired
	private MyClass116Service myClass116Service;
    

	@RequestMapping(value = "/myclass116/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass116/edit";	
	}

	@RequestMapping(value = "/myclass116/detail/{myClass116Id}")
	public String details (@PathVariable(value = "myClass116Id") Long myClass116Id, Model model) 
	{
		MyClass116 myClass116 = this.myClass116Service.findById(myClass116Id);
		model.addAttribute(myClass116);
		return "myclass116/detail";	
	}

	@RequestMapping(value = "/myclass116/edit/{myClass116Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass116Id") Long myClass116Id, Model model) 
	{
		MyClass116 myClass116 = this.myClass116Service.findById(myClass116Id);
		model.addAttribute(myClass116);
		return "myclass116/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass116Validator());	
	}

	@RequestMapping(value = "/myclass116/edit", method = RequestMethod.GET)
	public MyClass116 newMyClass116 (Model model) 
	{
		if(model != null && model.asMap().get("myclass116") == null)
		{
			return new MyClass116();	
		}
		return (MyClass116) model.asMap().get("myclass116");	
	}

	@RequestMapping(value = {"/myclass116/edit", "/myclass116/edit/{myclass116Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass116 MyClass116, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass116/edit";
		}
		
		
		
		this.myClass116Service.save(MyClass116);
		session.setComplete();
		return "redirect:/myclass116/list";	
	}


}
