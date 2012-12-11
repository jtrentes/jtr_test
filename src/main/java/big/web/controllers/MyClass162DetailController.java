package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass162Validator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass162;
import big.services.MyClass162Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass162.class)
public class MyClass162DetailController
{

	
	@Autowired
	private MyClass162Service myClass162Service;
    

	@RequestMapping(value = "/myclass162/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass162/edit";	
	}

	@RequestMapping(value = "/myclass162/detail/{myClass162Id}")
	public String details (@PathVariable(value = "myClass162Id") Long myClass162Id, Model model) 
	{
		MyClass162 myClass162 = this.myClass162Service.findById(myClass162Id);
		model.addAttribute(myClass162);
		return "myclass162/detail";	
	}

	@RequestMapping(value = "/myclass162/edit/{myClass162Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass162Id") Long myClass162Id, Model model) 
	{
		MyClass162 myClass162 = this.myClass162Service.findById(myClass162Id);
		model.addAttribute(myClass162);
		return "myclass162/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass162Validator());	
	}

	@RequestMapping(value = "/myclass162/edit", method = RequestMethod.GET)
	public MyClass162 newMyClass162 (Model model) 
	{
		if(model != null && model.asMap().get("myclass162") == null)
		{
			return new MyClass162();	
		}
		return (MyClass162) model.asMap().get("myclass162");	
	}

	@RequestMapping(value = {"/myclass162/edit", "/myclass162/edit/{myclass162Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass162 MyClass162, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass162/edit";
		}
		
		
		
		this.myClass162Service.save(MyClass162);
		session.setComplete();
		return "redirect:/myclass162/list";	
	}


}
