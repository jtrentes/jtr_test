package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass23;
import big.web.controllers.validator.MyClass111Validator;
import big.services.MyClass111Service;
import big.domain.MyClass111;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.services.MyClass23Service;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass111.class)
public class MyClass111DetailController
{

	
	@Autowired
	private MyClass111Service myClass111Service;
	
	@Autowired
	private MyClass23Service myClass23Service;
    

	@RequestMapping(value = "/myclass111/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass111/edit";	
	}

	@RequestMapping(value = "/myclass111/detail/{myClass111Id}")
	public String details (@PathVariable(value = "myClass111Id") Long myClass111Id, Model model) 
	{
		MyClass111 myClass111 = this.myClass111Service.findById(myClass111Id);
		model.addAttribute(myClass111);
		return "myclass111/detail";	
	}

	@RequestMapping(value = "/myclass111/edit/{myClass111Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass111Id") Long myClass111Id, Model model) 
	{
		MyClass111 myClass111 = this.myClass111Service.findById(myClass111Id);
		model.addAttribute(myClass111);
		return "myclass111/edit";	
	}

	@ModelAttribute(value = "myclass23s")
	public List<MyClass23> getMyClass23s () 
	{
		return this.myClass23Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass111Validator());	
	}

	@RequestMapping(value = "/myclass111/edit", method = RequestMethod.GET)
	public MyClass111 newMyClass111 (Model model) 
	{
		if(model != null && model.asMap().get("myclass111") == null)
		{
			return new MyClass111();	
		}
		return (MyClass111) model.asMap().get("myclass111");	
	}

	@RequestMapping(value = {"/myclass111/edit", "/myclass111/edit/{myclass111Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass111 MyClass111, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass111/edit";
		}
		
		if (MyClass111.getMyclass23()!=null && MyClass111.getMyclass23().getId()!=null && MyClass111.getMyclass23().getId() == 0)
			MyClass111.setMyclass23(null);
		
		
		this.myClass111Service.save(MyClass111);
		session.setComplete();
		return "redirect:/myclass111/list";	
	}


}
