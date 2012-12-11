package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass27Validator;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass24Service;
import org.springframework.validation.BindingResult;
import java.util.List;
import big.domain.MyClass24;
import big.services.MyClass27Service;
import big.domain.MyClass27;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass27.class)
public class MyClass27DetailController
{

	
	@Autowired
	private MyClass24Service myClass24Service;
	
	@Autowired
	private MyClass27Service myClass27Service;
    

	@RequestMapping(value = "/myclass27/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass27/edit";	
	}

	@RequestMapping(value = "/myclass27/detail/{myClass27Id}")
	public String details (@PathVariable(value = "myClass27Id") Long myClass27Id, Model model) 
	{
		MyClass27 myClass27 = this.myClass27Service.findById(myClass27Id);
		model.addAttribute(myClass27);
		return "myclass27/detail";	
	}

	@RequestMapping(value = "/myclass27/edit/{myClass27Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass27Id") Long myClass27Id, Model model) 
	{
		MyClass27 myClass27 = this.myClass27Service.findById(myClass27Id);
		model.addAttribute(myClass27);
		return "myclass27/edit";	
	}

	@ModelAttribute(value = "myclass24s")
	public List<MyClass24> getMyClass24s () 
	{
		return this.myClass24Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass27Validator());	
	}

	@RequestMapping(value = "/myclass27/edit", method = RequestMethod.GET)
	public MyClass27 newMyClass27 (Model model) 
	{
		if(model != null && model.asMap().get("myclass27") == null)
		{
			return new MyClass27();	
		}
		return (MyClass27) model.asMap().get("myclass27");	
	}

	@RequestMapping(value = {"/myclass27/edit", "/myclass27/edit/{myclass27Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass27 MyClass27, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass27/edit";
		}
		
		if (MyClass27.getMyclass24()!=null && MyClass27.getMyclass24().getId()!=null && MyClass27.getMyclass24().getId() == 0)
			MyClass27.setMyclass24(null);
		
		
		this.myClass27Service.save(MyClass27);
		session.setComplete();
		return "redirect:/myclass27/list";	
	}


}
