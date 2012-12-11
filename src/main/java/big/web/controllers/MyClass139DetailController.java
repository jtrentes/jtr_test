package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass139;
import java.util.List;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass131Service;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass131;
import big.services.MyClass139Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass139Validator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass139.class)
public class MyClass139DetailController
{

	
	@Autowired
	private MyClass131Service myClass131Service;
	
	@Autowired
	private MyClass139Service myClass139Service;
    

	@RequestMapping(value = "/myclass139/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass139/edit";	
	}

	@RequestMapping(value = "/myclass139/detail/{myClass139Id}")
	public String details (@PathVariable(value = "myClass139Id") Long myClass139Id, Model model) 
	{
		MyClass139 myClass139 = this.myClass139Service.findById(myClass139Id);
		model.addAttribute(myClass139);
		return "myclass139/detail";	
	}

	@RequestMapping(value = "/myclass139/edit/{myClass139Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass139Id") Long myClass139Id, Model model) 
	{
		MyClass139 myClass139 = this.myClass139Service.findById(myClass139Id);
		model.addAttribute(myClass139);
		return "myclass139/edit";	
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
		binder.setValidator(new MyClass139Validator());	
	}

	@RequestMapping(value = "/myclass139/edit", method = RequestMethod.GET)
	public MyClass139 newMyClass139 (Model model) 
	{
		if(model != null && model.asMap().get("myclass139") == null)
		{
			return new MyClass139();	
		}
		return (MyClass139) model.asMap().get("myclass139");	
	}

	@RequestMapping(value = {"/myclass139/edit", "/myclass139/edit/{myclass139Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass139 MyClass139, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass139/edit";
		}
		
		if (MyClass139.getMyclass131()!=null && MyClass139.getMyclass131().getId()!=null && MyClass139.getMyclass131().getId() == 0)
			MyClass139.setMyclass131(null);
		
		
		this.myClass139Service.save(MyClass139);
		session.setComplete();
		return "redirect:/myclass139/list";	
	}


}
