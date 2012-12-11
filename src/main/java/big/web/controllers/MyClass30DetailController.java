package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass31;
import org.springframework.ui.Model;
import big.services.MyClass31Service;
import big.domain.MyClass30;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.services.MyClass30Service;
import big.services.MyClass107Service;
import big.web.controllers.validator.MyClass30Validator;
import java.util.List;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass107;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass30.class)
public class MyClass30DetailController
{

	
	@Autowired
	private MyClass107Service myClass107Service;
	
	@Autowired
	private MyClass30Service myClass30Service;
	
	@Autowired
	private MyClass31Service myClass31Service;
    

	@RequestMapping(value = "/myclass30/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass30/edit";	
	}

	@RequestMapping(value = "/myclass30/detail/{myClass30Id}")
	public String details (@PathVariable(value = "myClass30Id") Long myClass30Id, Model model) 
	{
		MyClass30 myClass30 = this.myClass30Service.findById(myClass30Id);
		model.addAttribute(myClass30);
		return "myclass30/detail";	
	}

	@RequestMapping(value = "/myclass30/edit/{myClass30Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass30Id") Long myClass30Id, Model model) 
	{
		MyClass30 myClass30 = this.myClass30Service.findById(myClass30Id);
		model.addAttribute(myClass30);
		return "myclass30/edit";	
	}

	@ModelAttribute(value = "myclass107s")
	public List<MyClass107> getMyClass107s () 
	{
		return this.myClass107Service.findAll();	
	}

	@ModelAttribute(value = "myclass31s")
	public List<MyClass31> getMyClass31s () 
	{
		return this.myClass31Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass30Validator());	
	}

	@RequestMapping(value = "/myclass30/edit", method = RequestMethod.GET)
	public MyClass30 newMyClass30 (Model model) 
	{
		if(model != null && model.asMap().get("myclass30") == null)
		{
			return new MyClass30();	
		}
		return (MyClass30) model.asMap().get("myclass30");	
	}

	@RequestMapping(value = {"/myclass30/edit", "/myclass30/edit/{myclass30Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass30 MyClass30, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass30/edit";
		}
		
		if (MyClass30.getMyclass31()!=null && MyClass30.getMyclass31().getId()!=null && MyClass30.getMyclass31().getId() == 0)
			MyClass30.setMyclass31(null);
		if (MyClass30.getMyclass107()!=null && MyClass30.getMyclass107().getId()!=null && MyClass30.getMyclass107().getId() == 0)
			MyClass30.setMyclass107(null);
		
		
		this.myClass30Service.save(MyClass30);
		session.setComplete();
		return "redirect:/myclass30/list";	
	}


}
