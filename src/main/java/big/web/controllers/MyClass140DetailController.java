package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass140;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import java.util.List;
import big.web.controllers.validator.MyClass140Validator;
import big.domain.MyClass97;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass140Service;
import big.services.MyClass97Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass140.class)
public class MyClass140DetailController
{

	
	@Autowired
	private MyClass140Service myClass140Service;
	
	@Autowired
	private MyClass97Service myClass97Service;
    

	@RequestMapping(value = "/myclass140/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass140/edit";	
	}

	@RequestMapping(value = "/myclass140/detail/{myClass140Id}")
	public String details (@PathVariable(value = "myClass140Id") Long myClass140Id, Model model) 
	{
		MyClass140 myClass140 = this.myClass140Service.findById(myClass140Id);
		model.addAttribute(myClass140);
		return "myclass140/detail";	
	}

	@RequestMapping(value = "/myclass140/edit/{myClass140Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass140Id") Long myClass140Id, Model model) 
	{
		MyClass140 myClass140 = this.myClass140Service.findById(myClass140Id);
		model.addAttribute(myClass140);
		return "myclass140/edit";	
	}

	@ModelAttribute(value = "myclass97s")
	public List<MyClass97> getMyClass97s () 
	{
		return this.myClass97Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass140Validator());	
	}

	@RequestMapping(value = "/myclass140/edit", method = RequestMethod.GET)
	public MyClass140 newMyClass140 (Model model) 
	{
		if(model != null && model.asMap().get("myclass140") == null)
		{
			return new MyClass140();	
		}
		return (MyClass140) model.asMap().get("myclass140");	
	}

	@RequestMapping(value = {"/myclass140/edit", "/myclass140/edit/{myclass140Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass140 MyClass140, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass140/edit";
		}
		
		if (MyClass140.getMyclass97()!=null && MyClass140.getMyclass97().getId()!=null && MyClass140.getMyclass97().getId() == 0)
			MyClass140.setMyclass97(null);
		
		
		this.myClass140Service.save(MyClass140);
		session.setComplete();
		return "redirect:/myclass140/list";	
	}


}
