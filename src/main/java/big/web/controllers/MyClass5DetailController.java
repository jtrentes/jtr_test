package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import java.util.List;
import big.domain.MyClass5;
import big.services.MyClass5Service;
import big.web.controllers.validator.MyClass5Validator;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass9Service;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass9;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass5.class)
public class MyClass5DetailController
{

	
	@Autowired
	private MyClass5Service myClass5Service;
	
	@Autowired
	private MyClass9Service myClass9Service;
    

	@RequestMapping(value = "/myclass5/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass5/edit";	
	}

	@RequestMapping(value = "/myclass5/detail/{myClass5Id}")
	public String details (@PathVariable(value = "myClass5Id") Long myClass5Id, Model model) 
	{
		MyClass5 myClass5 = this.myClass5Service.findById(myClass5Id);
		model.addAttribute(myClass5);
		return "myclass5/detail";	
	}

	@RequestMapping(value = "/myclass5/edit/{myClass5Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass5Id") Long myClass5Id, Model model) 
	{
		MyClass5 myClass5 = this.myClass5Service.findById(myClass5Id);
		model.addAttribute(myClass5);
		return "myclass5/edit";	
	}

	@ModelAttribute(value = "myclass9s")
	public List<MyClass9> getMyClass9s () 
	{
		return this.myClass9Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass5Validator());	
	}

	@RequestMapping(value = "/myclass5/edit", method = RequestMethod.GET)
	public MyClass5 newMyClass5 (Model model) 
	{
		if(model != null && model.asMap().get("myclass5") == null)
		{
			return new MyClass5();	
		}
		return (MyClass5) model.asMap().get("myclass5");	
	}

	@RequestMapping(value = {"/myclass5/edit", "/myclass5/edit/{myclass5Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass5 MyClass5, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass5/edit";
		}
		
		if (MyClass5.getMyclass9()!=null && MyClass5.getMyclass9().getId()!=null && MyClass5.getMyclass9().getId() == 0)
			MyClass5.setMyclass9(null);
		
		
		this.myClass5Service.save(MyClass5);
		session.setComplete();
		return "redirect:/myclass5/list";	
	}


}
