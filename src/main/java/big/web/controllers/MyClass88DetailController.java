package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass88Validator;
import big.services.MyClass88Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass88;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass88.class)
public class MyClass88DetailController
{

	
	@Autowired
	private MyClass88Service myClass88Service;
    

	@RequestMapping(value = "/myclass88/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass88/edit";	
	}

	@RequestMapping(value = "/myclass88/detail/{myClass88Id}")
	public String details (@PathVariable(value = "myClass88Id") Long myClass88Id, Model model) 
	{
		MyClass88 myClass88 = this.myClass88Service.findById(myClass88Id);
		model.addAttribute(myClass88);
		return "myclass88/detail";	
	}

	@RequestMapping(value = "/myclass88/edit/{myClass88Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass88Id") Long myClass88Id, Model model) 
	{
		MyClass88 myClass88 = this.myClass88Service.findById(myClass88Id);
		model.addAttribute(myClass88);
		return "myclass88/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass88Validator());	
	}

	@RequestMapping(value = "/myclass88/edit", method = RequestMethod.GET)
	public MyClass88 newMyClass88 (Model model) 
	{
		if(model != null && model.asMap().get("myclass88") == null)
		{
			return new MyClass88();	
		}
		return (MyClass88) model.asMap().get("myclass88");	
	}

	@RequestMapping(value = {"/myclass88/edit", "/myclass88/edit/{myclass88Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass88 MyClass88, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass88/edit";
		}
		
		
		
		this.myClass88Service.save(MyClass88);
		session.setComplete();
		return "redirect:/myclass88/list";	
	}


}
