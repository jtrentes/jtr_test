package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass30;
import big.services.MyClass120Service;
import big.domain.MyClass120;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass30Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import java.util.List;
import big.web.controllers.validator.MyClass120Validator;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass120.class)
public class MyClass120DetailController
{

	
	@Autowired
	private MyClass120Service myClass120Service;
	
	@Autowired
	private MyClass30Service myClass30Service;
    

	@RequestMapping(value = "/myclass120/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass120/edit";	
	}

	@RequestMapping(value = "/myclass120/detail/{myClass120Id}")
	public String details (@PathVariable(value = "myClass120Id") Long myClass120Id, Model model) 
	{
		MyClass120 myClass120 = this.myClass120Service.findById(myClass120Id);
		model.addAttribute(myClass120);
		return "myclass120/detail";	
	}

	@RequestMapping(value = "/myclass120/edit/{myClass120Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass120Id") Long myClass120Id, Model model) 
	{
		MyClass120 myClass120 = this.myClass120Service.findById(myClass120Id);
		model.addAttribute(myClass120);
		return "myclass120/edit";	
	}

	@ModelAttribute(value = "myclass30s")
	public List<MyClass30> getMyClass30s () 
	{
		return this.myClass30Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass120Validator());	
	}

	@RequestMapping(value = "/myclass120/edit", method = RequestMethod.GET)
	public MyClass120 newMyClass120 (Model model) 
	{
		if(model != null && model.asMap().get("myclass120") == null)
		{
			return new MyClass120();	
		}
		return (MyClass120) model.asMap().get("myclass120");	
	}

	@RequestMapping(value = {"/myclass120/edit", "/myclass120/edit/{myclass120Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass120 MyClass120, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass120/edit";
		}
		
		if (MyClass120.getMyclass30()!=null && MyClass120.getMyclass30().getId()!=null && MyClass120.getMyclass30().getId() == 0)
			MyClass120.setMyclass30(null);
		
		
		this.myClass120Service.save(MyClass120);
		session.setComplete();
		return "redirect:/myclass120/list";	
	}


}
