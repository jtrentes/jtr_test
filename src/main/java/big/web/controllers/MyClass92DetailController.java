package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass92Service;
import big.web.controllers.validator.MyClass92Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass92;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass92.class)
public class MyClass92DetailController
{

	
	@Autowired
	private MyClass92Service myClass92Service;
    

	@RequestMapping(value = "/myclass92/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass92/edit";	
	}

	@RequestMapping(value = "/myclass92/detail/{myClass92Id}")
	public String details (@PathVariable(value = "myClass92Id") Long myClass92Id, Model model) 
	{
		MyClass92 myClass92 = this.myClass92Service.findById(myClass92Id);
		model.addAttribute(myClass92);
		return "myclass92/detail";	
	}

	@RequestMapping(value = "/myclass92/edit/{myClass92Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass92Id") Long myClass92Id, Model model) 
	{
		MyClass92 myClass92 = this.myClass92Service.findById(myClass92Id);
		model.addAttribute(myClass92);
		return "myclass92/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass92Validator());	
	}

	@RequestMapping(value = "/myclass92/edit", method = RequestMethod.GET)
	public MyClass92 newMyClass92 (Model model) 
	{
		if(model != null && model.asMap().get("myclass92") == null)
		{
			return new MyClass92();	
		}
		return (MyClass92) model.asMap().get("myclass92");	
	}

	@RequestMapping(value = {"/myclass92/edit", "/myclass92/edit/{myclass92Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass92 MyClass92, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass92/edit";
		}
		
		
		
		this.myClass92Service.save(MyClass92);
		session.setComplete();
		return "redirect:/myclass92/list";	
	}


}
