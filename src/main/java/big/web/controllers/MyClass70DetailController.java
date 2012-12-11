package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass70Validator;
import big.domain.MyClass70;
import big.services.MyClass70Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass70.class)
public class MyClass70DetailController
{

	
	@Autowired
	private MyClass70Service myClass70Service;
    

	@RequestMapping(value = "/myclass70/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass70/edit";	
	}

	@RequestMapping(value = "/myclass70/detail/{myClass70Id}")
	public String details (@PathVariable(value = "myClass70Id") Long myClass70Id, Model model) 
	{
		MyClass70 myClass70 = this.myClass70Service.findById(myClass70Id);
		model.addAttribute(myClass70);
		return "myclass70/detail";	
	}

	@RequestMapping(value = "/myclass70/edit/{myClass70Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass70Id") Long myClass70Id, Model model) 
	{
		MyClass70 myClass70 = this.myClass70Service.findById(myClass70Id);
		model.addAttribute(myClass70);
		return "myclass70/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass70Validator());	
	}

	@RequestMapping(value = "/myclass70/edit", method = RequestMethod.GET)
	public MyClass70 newMyClass70 (Model model) 
	{
		if(model != null && model.asMap().get("myclass70") == null)
		{
			return new MyClass70();	
		}
		return (MyClass70) model.asMap().get("myclass70");	
	}

	@RequestMapping(value = {"/myclass70/edit", "/myclass70/edit/{myclass70Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass70 MyClass70, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass70/edit";
		}
		
		
		
		this.myClass70Service.save(MyClass70);
		session.setComplete();
		return "redirect:/myclass70/list";	
	}


}
