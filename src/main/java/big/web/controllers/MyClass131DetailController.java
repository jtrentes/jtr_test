package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass131Validator;
import java.util.List;
import big.services.MyClass120Service;
import big.domain.MyClass120;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.BindingResult;
import big.services.MyClass131Service;
import big.domain.MyClass131;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass131.class)
public class MyClass131DetailController
{

	
	@Autowired
	private MyClass120Service myClass120Service;
	
	@Autowired
	private MyClass131Service myClass131Service;
    

	@RequestMapping(value = "/myclass131/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass131/edit";	
	}

	@RequestMapping(value = "/myclass131/detail/{myClass131Id}")
	public String details (@PathVariable(value = "myClass131Id") Long myClass131Id, Model model) 
	{
		MyClass131 myClass131 = this.myClass131Service.findById(myClass131Id);
		model.addAttribute(myClass131);
		return "myclass131/detail";	
	}

	@RequestMapping(value = "/myclass131/edit/{myClass131Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass131Id") Long myClass131Id, Model model) 
	{
		MyClass131 myClass131 = this.myClass131Service.findById(myClass131Id);
		model.addAttribute(myClass131);
		return "myclass131/edit";	
	}

	@ModelAttribute(value = "myclass120s")
	public List<MyClass120> getMyClass120s () 
	{
		return this.myClass120Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass131Validator());	
	}

	@RequestMapping(value = "/myclass131/edit", method = RequestMethod.GET)
	public MyClass131 newMyClass131 (Model model) 
	{
		if(model != null && model.asMap().get("myclass131") == null)
		{
			return new MyClass131();	
		}
		return (MyClass131) model.asMap().get("myclass131");	
	}

	@RequestMapping(value = {"/myclass131/edit", "/myclass131/edit/{myclass131Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass131 MyClass131, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass131/edit";
		}
		
		if (MyClass131.getMyclass120()!=null && MyClass131.getMyclass120().getId()!=null && MyClass131.getMyclass120().getId() == 0)
			MyClass131.setMyclass120(null);
		
		
		this.myClass131Service.save(MyClass131);
		session.setComplete();
		return "redirect:/myclass131/list";	
	}


}
