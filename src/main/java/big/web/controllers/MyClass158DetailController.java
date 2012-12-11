package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass158Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass158Service;
import org.springframework.ui.Model;
import big.domain.MyClass158;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass158.class)
public class MyClass158DetailController
{

	
	@Autowired
	private MyClass158Service myClass158Service;
    

	@RequestMapping(value = "/myclass158/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass158/edit";	
	}

	@RequestMapping(value = "/myclass158/detail/{myClass158Id}")
	public String details (@PathVariable(value = "myClass158Id") Long myClass158Id, Model model) 
	{
		MyClass158 myClass158 = this.myClass158Service.findById(myClass158Id);
		model.addAttribute(myClass158);
		return "myclass158/detail";	
	}

	@RequestMapping(value = "/myclass158/edit/{myClass158Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass158Id") Long myClass158Id, Model model) 
	{
		MyClass158 myClass158 = this.myClass158Service.findById(myClass158Id);
		model.addAttribute(myClass158);
		return "myclass158/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass158Validator());	
	}

	@RequestMapping(value = "/myclass158/edit", method = RequestMethod.GET)
	public MyClass158 newMyClass158 (Model model) 
	{
		if(model != null && model.asMap().get("myclass158") == null)
		{
			return new MyClass158();	
		}
		return (MyClass158) model.asMap().get("myclass158");	
	}

	@RequestMapping(value = {"/myclass158/edit", "/myclass158/edit/{myclass158Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass158 MyClass158, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass158/edit";
		}
		
		
		
		this.myClass158Service.save(MyClass158);
		session.setComplete();
		return "redirect:/myclass158/list";	
	}


}
