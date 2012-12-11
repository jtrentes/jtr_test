package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass150Service;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass150Validator;
import big.domain.MyClass150;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass150.class)
public class MyClass150DetailController
{

	
	@Autowired
	private MyClass150Service myClass150Service;
    

	@RequestMapping(value = "/myclass150/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass150/edit";	
	}

	@RequestMapping(value = "/myclass150/detail/{myClass150Id}")
	public String details (@PathVariable(value = "myClass150Id") Long myClass150Id, Model model) 
	{
		MyClass150 myClass150 = this.myClass150Service.findById(myClass150Id);
		model.addAttribute(myClass150);
		return "myclass150/detail";	
	}

	@RequestMapping(value = "/myclass150/edit/{myClass150Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass150Id") Long myClass150Id, Model model) 
	{
		MyClass150 myClass150 = this.myClass150Service.findById(myClass150Id);
		model.addAttribute(myClass150);
		return "myclass150/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass150Validator());	
	}

	@RequestMapping(value = "/myclass150/edit", method = RequestMethod.GET)
	public MyClass150 newMyClass150 (Model model) 
	{
		if(model != null && model.asMap().get("myclass150") == null)
		{
			return new MyClass150();	
		}
		return (MyClass150) model.asMap().get("myclass150");	
	}

	@RequestMapping(value = {"/myclass150/edit", "/myclass150/edit/{myclass150Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass150 MyClass150, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass150/edit";
		}
		
		
		
		this.myClass150Service.save(MyClass150);
		session.setComplete();
		return "redirect:/myclass150/list";	
	}


}
