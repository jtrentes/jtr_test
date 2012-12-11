package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.services.MyClass52Service;
import big.web.controllers.validator.MyClass52Validator;
import big.domain.MyClass52;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
@SessionAttributes(types = MyClass52.class)
public class MyClass52DetailController
{

	
	@Autowired
	private MyClass52Service myClass52Service;
    

	@RequestMapping(value = "/myclass52/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass52/edit";	
	}

	@RequestMapping(value = "/myclass52/detail/{myClass52Id}")
	public String details (@PathVariable(value = "myClass52Id") Long myClass52Id, Model model) 
	{
		MyClass52 myClass52 = this.myClass52Service.findById(myClass52Id);
		model.addAttribute(myClass52);
		return "myclass52/detail";	
	}

	@RequestMapping(value = "/myclass52/edit/{myClass52Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass52Id") Long myClass52Id, Model model) 
	{
		MyClass52 myClass52 = this.myClass52Service.findById(myClass52Id);
		model.addAttribute(myClass52);
		return "myclass52/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass52Validator());	
	}

	@RequestMapping(value = "/myclass52/edit", method = RequestMethod.GET)
	public MyClass52 newMyClass52 (Model model) 
	{
		if(model != null && model.asMap().get("myclass52") == null)
		{
			return new MyClass52();	
		}
		return (MyClass52) model.asMap().get("myclass52");	
	}

	@RequestMapping(value = {"/myclass52/edit", "/myclass52/edit/{myclass52Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass52 MyClass52, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass52/edit";
		}
		
		
		
		this.myClass52Service.save(MyClass52);
		session.setComplete();
		return "redirect:/myclass52/list";	
	}


}
