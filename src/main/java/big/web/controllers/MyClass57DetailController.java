package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass57Service;
import big.web.controllers.validator.MyClass57Validator;
import big.domain.MyClass57;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass37;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.services.MyClass37Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass57.class)
public class MyClass57DetailController
{

	
	@Autowired
	private MyClass37Service myClass37Service;
	
	@Autowired
	private MyClass57Service myClass57Service;
    

	@RequestMapping(value = "/myclass57/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass57/edit";	
	}

	@RequestMapping(value = "/myclass57/detail/{myClass57Id}")
	public String details (@PathVariable(value = "myClass57Id") Long myClass57Id, Model model) 
	{
		MyClass57 myClass57 = this.myClass57Service.findById(myClass57Id);
		model.addAttribute(myClass57);
		return "myclass57/detail";	
	}

	@RequestMapping(value = "/myclass57/edit/{myClass57Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass57Id") Long myClass57Id, Model model) 
	{
		MyClass57 myClass57 = this.myClass57Service.findById(myClass57Id);
		model.addAttribute(myClass57);
		return "myclass57/edit";	
	}

	@ModelAttribute(value = "myclass37s")
	public List<MyClass37> getMyClass37s () 
	{
		return this.myClass37Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass57Validator());	
	}

	@RequestMapping(value = "/myclass57/edit", method = RequestMethod.GET)
	public MyClass57 newMyClass57 (Model model) 
	{
		if(model != null && model.asMap().get("myclass57") == null)
		{
			return new MyClass57();	
		}
		return (MyClass57) model.asMap().get("myclass57");	
	}

	@RequestMapping(value = {"/myclass57/edit", "/myclass57/edit/{myclass57Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass57 MyClass57, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass57/edit";
		}
		
		if (MyClass57.getMyclass37()!=null && MyClass57.getMyclass37().getId()!=null && MyClass57.getMyclass37().getId() == 0)
			MyClass57.setMyclass37(null);
		
		
		this.myClass57Service.save(MyClass57);
		session.setComplete();
		return "redirect:/myclass57/list";	
	}


}
