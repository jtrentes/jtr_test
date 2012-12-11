package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass106Validator;
import big.services.MyClass106Service;
import big.domain.MyClass106;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass106.class)
public class MyClass106DetailController
{

	
	@Autowired
	private MyClass106Service myClass106Service;
    

	@RequestMapping(value = "/myclass106/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass106/edit";	
	}

	@RequestMapping(value = "/myclass106/detail/{myClass106Id}")
	public String details (@PathVariable(value = "myClass106Id") Long myClass106Id, Model model) 
	{
		MyClass106 myClass106 = this.myClass106Service.findById(myClass106Id);
		model.addAttribute(myClass106);
		return "myclass106/detail";	
	}

	@RequestMapping(value = "/myclass106/edit/{myClass106Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass106Id") Long myClass106Id, Model model) 
	{
		MyClass106 myClass106 = this.myClass106Service.findById(myClass106Id);
		model.addAttribute(myClass106);
		return "myclass106/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass106Validator());	
	}

	@RequestMapping(value = "/myclass106/edit", method = RequestMethod.GET)
	public MyClass106 newMyClass106 (Model model) 
	{
		if(model != null && model.asMap().get("myclass106") == null)
		{
			return new MyClass106();	
		}
		return (MyClass106) model.asMap().get("myclass106");	
	}

	@RequestMapping(value = {"/myclass106/edit", "/myclass106/edit/{myclass106Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass106 MyClass106, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass106/edit";
		}
		
		
		
		this.myClass106Service.save(MyClass106);
		session.setComplete();
		return "redirect:/myclass106/list";	
	}


}
