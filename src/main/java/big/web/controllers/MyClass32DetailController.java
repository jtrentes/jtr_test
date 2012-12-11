package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass32Service;
import big.domain.MyClass62;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass32Validator;
import org.springframework.ui.Model;
import big.domain.MyClass32;
import java.util.List;
import big.services.MyClass62Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass32.class)
public class MyClass32DetailController
{

	
	@Autowired
	private MyClass32Service myClass32Service;
	
	@Autowired
	private MyClass62Service myClass62Service;
    

	@RequestMapping(value = "/myclass32/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass32/edit";	
	}

	@RequestMapping(value = "/myclass32/detail/{myClass32Id}")
	public String details (@PathVariable(value = "myClass32Id") Long myClass32Id, Model model) 
	{
		MyClass32 myClass32 = this.myClass32Service.findById(myClass32Id);
		model.addAttribute(myClass32);
		return "myclass32/detail";	
	}

	@RequestMapping(value = "/myclass32/edit/{myClass32Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass32Id") Long myClass32Id, Model model) 
	{
		MyClass32 myClass32 = this.myClass32Service.findById(myClass32Id);
		model.addAttribute(myClass32);
		return "myclass32/edit";	
	}

	@ModelAttribute(value = "myclass62s")
	public List<MyClass62> getMyClass62s () 
	{
		return this.myClass62Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass32Validator());	
	}

	@RequestMapping(value = "/myclass32/edit", method = RequestMethod.GET)
	public MyClass32 newMyClass32 (Model model) 
	{
		if(model != null && model.asMap().get("myclass32") == null)
		{
			return new MyClass32();	
		}
		return (MyClass32) model.asMap().get("myclass32");	
	}

	@RequestMapping(value = {"/myclass32/edit", "/myclass32/edit/{myclass32Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass32 MyClass32, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass32/edit";
		}
		
		if (MyClass32.getMyclass62()!=null && MyClass32.getMyclass62().getId()!=null && MyClass32.getMyclass62().getId() == 0)
			MyClass32.setMyclass62(null);
		
		
		this.myClass32Service.save(MyClass32);
		session.setComplete();
		return "redirect:/myclass32/list";	
	}


}
