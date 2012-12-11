package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass58;
import big.web.controllers.validator.MyClass117Validator;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass117Service;
import big.domain.MyClass117;
import java.util.List;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass58Service;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass117.class)
public class MyClass117DetailController
{

	
	@Autowired
	private MyClass117Service myClass117Service;
	
	@Autowired
	private MyClass58Service myClass58Service;
    

	@RequestMapping(value = "/myclass117/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass117/edit";	
	}

	@RequestMapping(value = "/myclass117/detail/{myClass117Id}")
	public String details (@PathVariable(value = "myClass117Id") Long myClass117Id, Model model) 
	{
		MyClass117 myClass117 = this.myClass117Service.findById(myClass117Id);
		model.addAttribute(myClass117);
		return "myclass117/detail";	
	}

	@RequestMapping(value = "/myclass117/edit/{myClass117Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass117Id") Long myClass117Id, Model model) 
	{
		MyClass117 myClass117 = this.myClass117Service.findById(myClass117Id);
		model.addAttribute(myClass117);
		return "myclass117/edit";	
	}

	@ModelAttribute(value = "myclass58s")
	public List<MyClass58> getMyClass58s () 
	{
		return this.myClass58Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass117Validator());	
	}

	@RequestMapping(value = "/myclass117/edit", method = RequestMethod.GET)
	public MyClass117 newMyClass117 (Model model) 
	{
		if(model != null && model.asMap().get("myclass117") == null)
		{
			return new MyClass117();	
		}
		return (MyClass117) model.asMap().get("myclass117");	
	}

	@RequestMapping(value = {"/myclass117/edit", "/myclass117/edit/{myclass117Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass117 MyClass117, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass117/edit";
		}
		
		if (MyClass117.getMyclass58()!=null && MyClass117.getMyclass58().getId()!=null && MyClass117.getMyclass58().getId() == 0)
			MyClass117.setMyclass58(null);
		
		
		this.myClass117Service.save(MyClass117);
		session.setComplete();
		return "redirect:/myclass117/list";	
	}


}
