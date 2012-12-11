package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import big.services.MyClass132Service;
import big.domain.MyClass132;
import big.web.controllers.validator.MyClass132Validator;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass132.class)
public class MyClass132DetailController
{

	
	@Autowired
	private MyClass132Service myClass132Service;
    

	@RequestMapping(value = "/myclass132/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass132/edit";	
	}

	@RequestMapping(value = "/myclass132/detail/{myClass132Id}")
	public String details (@PathVariable(value = "myClass132Id") Long myClass132Id, Model model) 
	{
		MyClass132 myClass132 = this.myClass132Service.findById(myClass132Id);
		model.addAttribute(myClass132);
		return "myclass132/detail";	
	}

	@RequestMapping(value = "/myclass132/edit/{myClass132Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass132Id") Long myClass132Id, Model model) 
	{
		MyClass132 myClass132 = this.myClass132Service.findById(myClass132Id);
		model.addAttribute(myClass132);
		return "myclass132/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass132Validator());	
	}

	@RequestMapping(value = "/myclass132/edit", method = RequestMethod.GET)
	public MyClass132 newMyClass132 (Model model) 
	{
		if(model != null && model.asMap().get("myclass132") == null)
		{
			return new MyClass132();	
		}
		return (MyClass132) model.asMap().get("myclass132");	
	}

	@RequestMapping(value = {"/myclass132/edit", "/myclass132/edit/{myclass132Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass132 MyClass132, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass132/edit";
		}
		
		
		
		this.myClass132Service.save(MyClass132);
		session.setComplete();
		return "redirect:/myclass132/list";	
	}


}
