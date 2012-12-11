package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass81Service;
import big.web.controllers.validator.MyClass9Validator;
import org.springframework.validation.BindingResult;
import big.services.MyClass9Service;
import big.domain.MyClass9;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass81;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass9.class)
public class MyClass9DetailController
{

	
	@Autowired
	private MyClass81Service myClass81Service;
	
	@Autowired
	private MyClass9Service myClass9Service;
    

	@RequestMapping(value = "/myclass9/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass9/edit";	
	}

	@RequestMapping(value = "/myclass9/detail/{myClass9Id}")
	public String details (@PathVariable(value = "myClass9Id") Long myClass9Id, Model model) 
	{
		MyClass9 myClass9 = this.myClass9Service.findById(myClass9Id);
		model.addAttribute(myClass9);
		return "myclass9/detail";	
	}

	@RequestMapping(value = "/myclass9/edit/{myClass9Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass9Id") Long myClass9Id, Model model) 
	{
		MyClass9 myClass9 = this.myClass9Service.findById(myClass9Id);
		model.addAttribute(myClass9);
		return "myclass9/edit";	
	}

	@ModelAttribute(value = "myclass81s")
	public List<MyClass81> getMyClass81s () 
	{
		return this.myClass81Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass9Validator());	
	}

	@RequestMapping(value = "/myclass9/edit", method = RequestMethod.GET)
	public MyClass9 newMyClass9 (Model model) 
	{
		if(model != null && model.asMap().get("myclass9") == null)
		{
			return new MyClass9();	
		}
		return (MyClass9) model.asMap().get("myclass9");	
	}

	@RequestMapping(value = {"/myclass9/edit", "/myclass9/edit/{myclass9Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass9 MyClass9, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass9/edit";
		}
		
		if (MyClass9.getMyclass81()!=null && MyClass9.getMyclass81().getId()!=null && MyClass9.getMyclass81().getId() == 0)
			MyClass9.setMyclass81(null);
		
		
		this.myClass9Service.save(MyClass9);
		session.setComplete();
		return "redirect:/myclass9/list";	
	}


}
