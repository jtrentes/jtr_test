package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass69Service;
import big.web.controllers.validator.MyClass69Validator;
import java.util.List;
import big.domain.MyClass69;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import big.domain.MyClass70;
import org.springframework.ui.Model;
import big.services.MyClass70Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass69.class)
public class MyClass69DetailController
{

	
	@Autowired
	private MyClass69Service myClass69Service;
	
	@Autowired
	private MyClass70Service myClass70Service;
    

	@RequestMapping(value = "/myclass69/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass69/edit";	
	}

	@RequestMapping(value = "/myclass69/detail/{myClass69Id}")
	public String details (@PathVariable(value = "myClass69Id") Long myClass69Id, Model model) 
	{
		MyClass69 myClass69 = this.myClass69Service.findById(myClass69Id);
		model.addAttribute(myClass69);
		return "myclass69/detail";	
	}

	@RequestMapping(value = "/myclass69/edit/{myClass69Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass69Id") Long myClass69Id, Model model) 
	{
		MyClass69 myClass69 = this.myClass69Service.findById(myClass69Id);
		model.addAttribute(myClass69);
		return "myclass69/edit";	
	}

	@ModelAttribute(value = "myclass70s")
	public List<MyClass70> getMyClass70s () 
	{
		return this.myClass70Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass69Validator());	
	}

	@RequestMapping(value = "/myclass69/edit", method = RequestMethod.GET)
	public MyClass69 newMyClass69 (Model model) 
	{
		if(model != null && model.asMap().get("myclass69") == null)
		{
			return new MyClass69();	
		}
		return (MyClass69) model.asMap().get("myclass69");	
	}

	@RequestMapping(value = {"/myclass69/edit", "/myclass69/edit/{myclass69Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass69 MyClass69, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass69/edit";
		}
		
		if (MyClass69.getMyclass70()!=null && MyClass69.getMyclass70().getId()!=null && MyClass69.getMyclass70().getId() == 0)
			MyClass69.setMyclass70(null);
		
		
		this.myClass69Service.save(MyClass69);
		session.setComplete();
		return "redirect:/myclass69/list";	
	}


}
