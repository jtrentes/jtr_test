package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass107Service;
import big.domain.MyClass107;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass107Validator;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass112Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import java.util.List;
import big.domain.MyClass112;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass107.class)
public class MyClass107DetailController
{

	
	@Autowired
	private MyClass107Service myClass107Service;
	
	@Autowired
	private MyClass112Service myClass112Service;
    

	@RequestMapping(value = "/myclass107/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass107/edit";	
	}

	@RequestMapping(value = "/myclass107/detail/{myClass107Id}")
	public String details (@PathVariable(value = "myClass107Id") Long myClass107Id, Model model) 
	{
		MyClass107 myClass107 = this.myClass107Service.findById(myClass107Id);
		model.addAttribute(myClass107);
		return "myclass107/detail";	
	}

	@RequestMapping(value = "/myclass107/edit/{myClass107Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass107Id") Long myClass107Id, Model model) 
	{
		MyClass107 myClass107 = this.myClass107Service.findById(myClass107Id);
		model.addAttribute(myClass107);
		return "myclass107/edit";	
	}

	@ModelAttribute(value = "myclass112s")
	public List<MyClass112> getMyClass112s () 
	{
		return this.myClass112Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass107Validator());	
	}

	@RequestMapping(value = "/myclass107/edit", method = RequestMethod.GET)
	public MyClass107 newMyClass107 (Model model) 
	{
		if(model != null && model.asMap().get("myclass107") == null)
		{
			return new MyClass107();	
		}
		return (MyClass107) model.asMap().get("myclass107");	
	}

	@RequestMapping(value = {"/myclass107/edit", "/myclass107/edit/{myclass107Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass107 MyClass107, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass107/edit";
		}
		
		if (MyClass107.getMyclass112()!=null && MyClass107.getMyclass112().getId()!=null && MyClass107.getMyclass112().getId() == 0)
			MyClass107.setMyclass112(null);
		
		
		this.myClass107Service.save(MyClass107);
		session.setComplete();
		return "redirect:/myclass107/list";	
	}


}
