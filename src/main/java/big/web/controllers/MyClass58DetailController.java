package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass131;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass58Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.web.controllers.validator.MyClass58Validator;
import big.services.MyClass131Service;
import big.domain.MyClass58;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass58.class)
public class MyClass58DetailController
{

	
	@Autowired
	private MyClass131Service myClass131Service;
	
	@Autowired
	private MyClass58Service myClass58Service;
    

	@RequestMapping(value = "/myclass58/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass58/edit";	
	}

	@RequestMapping(value = "/myclass58/detail/{myClass58Id}")
	public String details (@PathVariable(value = "myClass58Id") Long myClass58Id, Model model) 
	{
		MyClass58 myClass58 = this.myClass58Service.findById(myClass58Id);
		model.addAttribute(myClass58);
		return "myclass58/detail";	
	}

	@RequestMapping(value = "/myclass58/edit/{myClass58Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass58Id") Long myClass58Id, Model model) 
	{
		MyClass58 myClass58 = this.myClass58Service.findById(myClass58Id);
		model.addAttribute(myClass58);
		return "myclass58/edit";	
	}

	@ModelAttribute(value = "myclass131s")
	public List<MyClass131> getMyClass131s () 
	{
		return this.myClass131Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass58Validator());	
	}

	@RequestMapping(value = "/myclass58/edit", method = RequestMethod.GET)
	public MyClass58 newMyClass58 (Model model) 
	{
		if(model != null && model.asMap().get("myclass58") == null)
		{
			return new MyClass58();	
		}
		return (MyClass58) model.asMap().get("myclass58");	
	}

	@RequestMapping(value = {"/myclass58/edit", "/myclass58/edit/{myclass58Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass58 MyClass58, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass58/edit";
		}
		
		if (MyClass58.getMyclass131()!=null && MyClass58.getMyclass131().getId()!=null && MyClass58.getMyclass131().getId() == 0)
			MyClass58.setMyclass131(null);
		
		
		this.myClass58Service.save(MyClass58);
		session.setComplete();
		return "redirect:/myclass58/list";	
	}


}
