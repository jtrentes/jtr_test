package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass160Service;
import big.domain.MyClass160;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass160Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass160.class)
public class MyClass160DetailController
{

	
	@Autowired
	private MyClass160Service myClass160Service;
    

	@RequestMapping(value = "/myclass160/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass160/edit";	
	}

	@RequestMapping(value = "/myclass160/detail/{myClass160Id}")
	public String details (@PathVariable(value = "myClass160Id") Long myClass160Id, Model model) 
	{
		MyClass160 myClass160 = this.myClass160Service.findById(myClass160Id);
		model.addAttribute(myClass160);
		return "myclass160/detail";	
	}

	@RequestMapping(value = "/myclass160/edit/{myClass160Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass160Id") Long myClass160Id, Model model) 
	{
		MyClass160 myClass160 = this.myClass160Service.findById(myClass160Id);
		model.addAttribute(myClass160);
		return "myclass160/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass160Validator());	
	}

	@RequestMapping(value = "/myclass160/edit", method = RequestMethod.GET)
	public MyClass160 newMyClass160 (Model model) 
	{
		if(model != null && model.asMap().get("myclass160") == null)
		{
			return new MyClass160();	
		}
		return (MyClass160) model.asMap().get("myclass160");	
	}

	@RequestMapping(value = {"/myclass160/edit", "/myclass160/edit/{myclass160Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass160 MyClass160, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass160/edit";
		}
		
		
		
		this.myClass160Service.save(MyClass160);
		session.setComplete();
		return "redirect:/myclass160/list";	
	}


}
