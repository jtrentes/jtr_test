package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass147Service;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass147Validator;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass147;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass147.class)
public class MyClass147DetailController
{

	
	@Autowired
	private MyClass147Service myClass147Service;
    

	@RequestMapping(value = "/myclass147/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass147/edit";	
	}

	@RequestMapping(value = "/myclass147/detail/{myClass147Id}")
	public String details (@PathVariable(value = "myClass147Id") Long myClass147Id, Model model) 
	{
		MyClass147 myClass147 = this.myClass147Service.findById(myClass147Id);
		model.addAttribute(myClass147);
		return "myclass147/detail";	
	}

	@RequestMapping(value = "/myclass147/edit/{myClass147Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass147Id") Long myClass147Id, Model model) 
	{
		MyClass147 myClass147 = this.myClass147Service.findById(myClass147Id);
		model.addAttribute(myClass147);
		return "myclass147/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass147Validator());	
	}

	@RequestMapping(value = "/myclass147/edit", method = RequestMethod.GET)
	public MyClass147 newMyClass147 (Model model) 
	{
		if(model != null && model.asMap().get("myclass147") == null)
		{
			return new MyClass147();	
		}
		return (MyClass147) model.asMap().get("myclass147");	
	}

	@RequestMapping(value = {"/myclass147/edit", "/myclass147/edit/{myclass147Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass147 MyClass147, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass147/edit";
		}
		
		
		
		this.myClass147Service.save(MyClass147);
		session.setComplete();
		return "redirect:/myclass147/list";	
	}


}
