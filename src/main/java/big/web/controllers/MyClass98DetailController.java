package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass98;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass98Validator;
import big.services.MyClass98Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass98.class)
public class MyClass98DetailController
{

	
	@Autowired
	private MyClass98Service myClass98Service;
    

	@RequestMapping(value = "/myclass98/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass98/edit";	
	}

	@RequestMapping(value = "/myclass98/detail/{myClass98Id}")
	public String details (@PathVariable(value = "myClass98Id") Long myClass98Id, Model model) 
	{
		MyClass98 myClass98 = this.myClass98Service.findById(myClass98Id);
		model.addAttribute(myClass98);
		return "myclass98/detail";	
	}

	@RequestMapping(value = "/myclass98/edit/{myClass98Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass98Id") Long myClass98Id, Model model) 
	{
		MyClass98 myClass98 = this.myClass98Service.findById(myClass98Id);
		model.addAttribute(myClass98);
		return "myclass98/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass98Validator());	
	}

	@RequestMapping(value = "/myclass98/edit", method = RequestMethod.GET)
	public MyClass98 newMyClass98 (Model model) 
	{
		if(model != null && model.asMap().get("myclass98") == null)
		{
			return new MyClass98();	
		}
		return (MyClass98) model.asMap().get("myclass98");	
	}

	@RequestMapping(value = {"/myclass98/edit", "/myclass98/edit/{myclass98Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass98 MyClass98, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass98/edit";
		}
		
		
		
		this.myClass98Service.save(MyClass98);
		session.setComplete();
		return "redirect:/myclass98/list";	
	}


}
