package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass156Service;
import org.springframework.validation.BindingResult;
import big.domain.MyClass156;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass156Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass156.class)
public class MyClass156DetailController
{

	
	@Autowired
	private MyClass156Service myClass156Service;
    

	@RequestMapping(value = "/myclass156/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass156/edit";	
	}

	@RequestMapping(value = "/myclass156/detail/{myClass156Id}")
	public String details (@PathVariable(value = "myClass156Id") Long myClass156Id, Model model) 
	{
		MyClass156 myClass156 = this.myClass156Service.findById(myClass156Id);
		model.addAttribute(myClass156);
		return "myclass156/detail";	
	}

	@RequestMapping(value = "/myclass156/edit/{myClass156Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass156Id") Long myClass156Id, Model model) 
	{
		MyClass156 myClass156 = this.myClass156Service.findById(myClass156Id);
		model.addAttribute(myClass156);
		return "myclass156/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass156Validator());	
	}

	@RequestMapping(value = "/myclass156/edit", method = RequestMethod.GET)
	public MyClass156 newMyClass156 (Model model) 
	{
		if(model != null && model.asMap().get("myclass156") == null)
		{
			return new MyClass156();	
		}
		return (MyClass156) model.asMap().get("myclass156");	
	}

	@RequestMapping(value = {"/myclass156/edit", "/myclass156/edit/{myclass156Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass156 MyClass156, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass156/edit";
		}
		
		
		
		this.myClass156Service.save(MyClass156);
		session.setComplete();
		return "redirect:/myclass156/list";	
	}


}
