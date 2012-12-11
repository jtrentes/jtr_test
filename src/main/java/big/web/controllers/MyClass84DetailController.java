package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass84Validator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass84Service;
import org.springframework.ui.Model;
import big.domain.MyClass84;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass84.class)
public class MyClass84DetailController
{

	
	@Autowired
	private MyClass84Service myClass84Service;
    

	@RequestMapping(value = "/myclass84/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass84/edit";	
	}

	@RequestMapping(value = "/myclass84/detail/{myClass84Id}")
	public String details (@PathVariable(value = "myClass84Id") Long myClass84Id, Model model) 
	{
		MyClass84 myClass84 = this.myClass84Service.findById(myClass84Id);
		model.addAttribute(myClass84);
		return "myclass84/detail";	
	}

	@RequestMapping(value = "/myclass84/edit/{myClass84Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass84Id") Long myClass84Id, Model model) 
	{
		MyClass84 myClass84 = this.myClass84Service.findById(myClass84Id);
		model.addAttribute(myClass84);
		return "myclass84/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass84Validator());	
	}

	@RequestMapping(value = "/myclass84/edit", method = RequestMethod.GET)
	public MyClass84 newMyClass84 (Model model) 
	{
		if(model != null && model.asMap().get("myclass84") == null)
		{
			return new MyClass84();	
		}
		return (MyClass84) model.asMap().get("myclass84");	
	}

	@RequestMapping(value = {"/myclass84/edit", "/myclass84/edit/{myclass84Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass84 MyClass84, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass84/edit";
		}
		
		
		
		this.myClass84Service.save(MyClass84);
		session.setComplete();
		return "redirect:/myclass84/list";	
	}


}
