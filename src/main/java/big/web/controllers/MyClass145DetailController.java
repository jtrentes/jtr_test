package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass145;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass145Validator;
import big.services.MyClass145Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass145.class)
public class MyClass145DetailController
{

	
	@Autowired
	private MyClass145Service myClass145Service;
    

	@RequestMapping(value = "/myclass145/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass145/edit";	
	}

	@RequestMapping(value = "/myclass145/detail/{myClass145Id}")
	public String details (@PathVariable(value = "myClass145Id") Long myClass145Id, Model model) 
	{
		MyClass145 myClass145 = this.myClass145Service.findById(myClass145Id);
		model.addAttribute(myClass145);
		return "myclass145/detail";	
	}

	@RequestMapping(value = "/myclass145/edit/{myClass145Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass145Id") Long myClass145Id, Model model) 
	{
		MyClass145 myClass145 = this.myClass145Service.findById(myClass145Id);
		model.addAttribute(myClass145);
		return "myclass145/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass145Validator());	
	}

	@RequestMapping(value = "/myclass145/edit", method = RequestMethod.GET)
	public MyClass145 newMyClass145 (Model model) 
	{
		if(model != null && model.asMap().get("myclass145") == null)
		{
			return new MyClass145();	
		}
		return (MyClass145) model.asMap().get("myclass145");	
	}

	@RequestMapping(value = {"/myclass145/edit", "/myclass145/edit/{myclass145Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass145 MyClass145, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass145/edit";
		}
		
		
		
		this.myClass145Service.save(MyClass145);
		session.setComplete();
		return "redirect:/myclass145/list";	
	}


}
