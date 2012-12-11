package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass28;
import big.web.controllers.validator.MyClass23Validator;
import big.services.MyClass23Service;
import big.domain.MyClass23;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass28Service;
import org.springframework.web.bind.WebDataBinder;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
@SessionAttributes(types = MyClass23.class)
public class MyClass23DetailController
{

	
	@Autowired
	private MyClass23Service myClass23Service;
	
	@Autowired
	private MyClass28Service myClass28Service;
    

	@RequestMapping(value = "/myclass23/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass23/edit";	
	}

	@RequestMapping(value = "/myclass23/detail/{myClass23Id}")
	public String details (@PathVariable(value = "myClass23Id") Long myClass23Id, Model model) 
	{
		MyClass23 myClass23 = this.myClass23Service.findById(myClass23Id);
		model.addAttribute(myClass23);
		return "myclass23/detail";	
	}

	@RequestMapping(value = "/myclass23/edit/{myClass23Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass23Id") Long myClass23Id, Model model) 
	{
		MyClass23 myClass23 = this.myClass23Service.findById(myClass23Id);
		model.addAttribute(myClass23);
		return "myclass23/edit";	
	}

	@ModelAttribute(value = "myclass28s")
	public List<MyClass28> getMyClass28s () 
	{
		return this.myClass28Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass23Validator());	
	}

	@RequestMapping(value = "/myclass23/edit", method = RequestMethod.GET)
	public MyClass23 newMyClass23 (Model model) 
	{
		if(model != null && model.asMap().get("myclass23") == null)
		{
			return new MyClass23();	
		}
		return (MyClass23) model.asMap().get("myclass23");	
	}

	@RequestMapping(value = {"/myclass23/edit", "/myclass23/edit/{myclass23Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass23 MyClass23, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass23/edit";
		}
		
		if (MyClass23.getMyclass28()!=null && MyClass23.getMyclass28().getId()!=null && MyClass23.getMyclass28().getId() == 0)
			MyClass23.setMyclass28(null);
		
		
		this.myClass23Service.save(MyClass23);
		session.setComplete();
		return "redirect:/myclass23/list";	
	}


}
