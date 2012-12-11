package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.domain.MyClass124;
import big.web.controllers.validator.MyClass89Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.domain.MyClass89;
import big.services.MyClass124Service;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass89Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass89.class)
public class MyClass89DetailController
{

	
	@Autowired
	private MyClass124Service myClass124Service;
	
	@Autowired
	private MyClass89Service myClass89Service;
    

	@RequestMapping(value = "/myclass89/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass89/edit";	
	}

	@RequestMapping(value = "/myclass89/detail/{myClass89Id}")
	public String details (@PathVariable(value = "myClass89Id") Long myClass89Id, Model model) 
	{
		MyClass89 myClass89 = this.myClass89Service.findById(myClass89Id);
		model.addAttribute(myClass89);
		return "myclass89/detail";	
	}

	@RequestMapping(value = "/myclass89/edit/{myClass89Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass89Id") Long myClass89Id, Model model) 
	{
		MyClass89 myClass89 = this.myClass89Service.findById(myClass89Id);
		model.addAttribute(myClass89);
		return "myclass89/edit";	
	}

	@ModelAttribute(value = "myclass124s")
	public List<MyClass124> getMyClass124s () 
	{
		return this.myClass124Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass89Validator());	
	}

	@RequestMapping(value = "/myclass89/edit", method = RequestMethod.GET)
	public MyClass89 newMyClass89 (Model model) 
	{
		if(model != null && model.asMap().get("myclass89") == null)
		{
			return new MyClass89();	
		}
		return (MyClass89) model.asMap().get("myclass89");	
	}

	@RequestMapping(value = {"/myclass89/edit", "/myclass89/edit/{myclass89Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass89 MyClass89, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass89/edit";
		}
		
		if (MyClass89.getMyclass124()!=null && MyClass89.getMyclass124().getId()!=null && MyClass89.getMyclass124().getId() == 0)
			MyClass89.setMyclass124(null);
		
		
		this.myClass89Service.save(MyClass89);
		session.setComplete();
		return "redirect:/myclass89/list";	
	}


}
