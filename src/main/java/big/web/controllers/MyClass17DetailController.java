package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass17Service;
import big.web.controllers.validator.MyClass17Validator;
import big.services.MyClass76Service;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass76;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass17;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass17.class)
public class MyClass17DetailController
{

	
	@Autowired
	private MyClass17Service myClass17Service;
	
	@Autowired
	private MyClass76Service myClass76Service;
    

	@RequestMapping(value = "/myclass17/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass17/edit";	
	}

	@RequestMapping(value = "/myclass17/detail/{myClass17Id}")
	public String details (@PathVariable(value = "myClass17Id") Long myClass17Id, Model model) 
	{
		MyClass17 myClass17 = this.myClass17Service.findById(myClass17Id);
		model.addAttribute(myClass17);
		return "myclass17/detail";	
	}

	@RequestMapping(value = "/myclass17/edit/{myClass17Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass17Id") Long myClass17Id, Model model) 
	{
		MyClass17 myClass17 = this.myClass17Service.findById(myClass17Id);
		model.addAttribute(myClass17);
		return "myclass17/edit";	
	}

	@ModelAttribute(value = "myclass76s")
	public List<MyClass76> getMyClass76s () 
	{
		return this.myClass76Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass17Validator());	
	}

	@RequestMapping(value = "/myclass17/edit", method = RequestMethod.GET)
	public MyClass17 newMyClass17 (Model model) 
	{
		if(model != null && model.asMap().get("myclass17") == null)
		{
			return new MyClass17();	
		}
		return (MyClass17) model.asMap().get("myclass17");	
	}

	@RequestMapping(value = {"/myclass17/edit", "/myclass17/edit/{myclass17Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass17 MyClass17, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass17/edit";
		}
		
		if (MyClass17.getMyclass76()!=null && MyClass17.getMyclass76().getId()!=null && MyClass17.getMyclass76().getId() == 0)
			MyClass17.setMyclass76(null);
		
		
		this.myClass17Service.save(MyClass17);
		session.setComplete();
		return "redirect:/myclass17/list";	
	}


}
