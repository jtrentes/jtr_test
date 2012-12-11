package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import java.util.List;
import org.springframework.validation.BindingResult;
import big.domain.MyClass155;
import big.services.MyClass39Service;
import big.domain.MyClass39;
import big.services.MyClass155Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass155Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass155.class)
public class MyClass155DetailController
{

	
	@Autowired
	private MyClass155Service myClass155Service;
	
	@Autowired
	private MyClass39Service myClass39Service;
    

	@RequestMapping(value = "/myclass155/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass155/edit";	
	}

	@RequestMapping(value = "/myclass155/detail/{myClass155Id}")
	public String details (@PathVariable(value = "myClass155Id") Long myClass155Id, Model model) 
	{
		MyClass155 myClass155 = this.myClass155Service.findById(myClass155Id);
		model.addAttribute(myClass155);
		return "myclass155/detail";	
	}

	@RequestMapping(value = "/myclass155/edit/{myClass155Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass155Id") Long myClass155Id, Model model) 
	{
		MyClass155 myClass155 = this.myClass155Service.findById(myClass155Id);
		model.addAttribute(myClass155);
		return "myclass155/edit";	
	}

	@ModelAttribute(value = "myclass39s")
	public List<MyClass39> getMyClass39s () 
	{
		return this.myClass39Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass155Validator());	
	}

	@RequestMapping(value = "/myclass155/edit", method = RequestMethod.GET)
	public MyClass155 newMyClass155 (Model model) 
	{
		if(model != null && model.asMap().get("myclass155") == null)
		{
			return new MyClass155();	
		}
		return (MyClass155) model.asMap().get("myclass155");	
	}

	@RequestMapping(value = {"/myclass155/edit", "/myclass155/edit/{myclass155Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass155 MyClass155, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass155/edit";
		}
		
		if (MyClass155.getMyclass39()!=null && MyClass155.getMyclass39().getId()!=null && MyClass155.getMyclass39().getId() == 0)
			MyClass155.setMyclass39(null);
		
		
		this.myClass155Service.save(MyClass155);
		session.setComplete();
		return "redirect:/myclass155/list";	
	}


}
