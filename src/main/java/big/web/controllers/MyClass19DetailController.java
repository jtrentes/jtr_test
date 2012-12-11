package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass19Service;
import big.web.controllers.validator.MyClass19Validator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass19;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass19.class)
public class MyClass19DetailController
{

	
	@Autowired
	private MyClass19Service myClass19Service;
    

	@RequestMapping(value = "/myclass19/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass19/edit";	
	}

	@RequestMapping(value = "/myclass19/detail/{myClass19Id}")
	public String details (@PathVariable(value = "myClass19Id") Long myClass19Id, Model model) 
	{
		MyClass19 myClass19 = this.myClass19Service.findById(myClass19Id);
		model.addAttribute(myClass19);
		return "myclass19/detail";	
	}

	@RequestMapping(value = "/myclass19/edit/{myClass19Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass19Id") Long myClass19Id, Model model) 
	{
		MyClass19 myClass19 = this.myClass19Service.findById(myClass19Id);
		model.addAttribute(myClass19);
		return "myclass19/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass19Validator());	
	}

	@RequestMapping(value = "/myclass19/edit", method = RequestMethod.GET)
	public MyClass19 newMyClass19 (Model model) 
	{
		if(model != null && model.asMap().get("myclass19") == null)
		{
			return new MyClass19();	
		}
		return (MyClass19) model.asMap().get("myclass19");	
	}

	@RequestMapping(value = {"/myclass19/edit", "/myclass19/edit/{myclass19Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass19 MyClass19, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass19/edit";
		}
		
		
		
		this.myClass19Service.save(MyClass19);
		session.setComplete();
		return "redirect:/myclass19/list";	
	}


}
