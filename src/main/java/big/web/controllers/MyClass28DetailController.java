package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import big.domain.MyClass28;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass25Service;
import java.util.List;
import big.domain.MyClass115;
import big.services.MyClass28Service;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass115Service;
import big.web.controllers.validator.MyClass28Validator;
import big.domain.MyClass25;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass28.class)
public class MyClass28DetailController
{

	
	@Autowired
	private MyClass115Service myClass115Service;
	
	@Autowired
	private MyClass25Service myClass25Service;
	
	@Autowired
	private MyClass28Service myClass28Service;
    

	@RequestMapping(value = "/myclass28/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass28/edit";	
	}

	@RequestMapping(value = "/myclass28/detail/{myClass28Id}")
	public String details (@PathVariable(value = "myClass28Id") Long myClass28Id, Model model) 
	{
		MyClass28 myClass28 = this.myClass28Service.findById(myClass28Id);
		model.addAttribute(myClass28);
		return "myclass28/detail";	
	}

	@RequestMapping(value = "/myclass28/edit/{myClass28Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass28Id") Long myClass28Id, Model model) 
	{
		MyClass28 myClass28 = this.myClass28Service.findById(myClass28Id);
		model.addAttribute(myClass28);
		return "myclass28/edit";	
	}

	@ModelAttribute(value = "myclass115s")
	public List<MyClass115> getMyClass115s () 
	{
		return this.myClass115Service.findAll();	
	}

	@ModelAttribute(value = "myclass25s")
	public List<MyClass25> getMyClass25s () 
	{
		return this.myClass25Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass28Validator());	
	}

	@RequestMapping(value = "/myclass28/edit", method = RequestMethod.GET)
	public MyClass28 newMyClass28 (Model model) 
	{
		if(model != null && model.asMap().get("myclass28") == null)
		{
			return new MyClass28();	
		}
		return (MyClass28) model.asMap().get("myclass28");	
	}

	@RequestMapping(value = {"/myclass28/edit", "/myclass28/edit/{myclass28Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass28 MyClass28, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass28/edit";
		}
		
		if (MyClass28.getMyclass25()!=null && MyClass28.getMyclass25().getId()!=null && MyClass28.getMyclass25().getId() == 0)
			MyClass28.setMyclass25(null);
		if (MyClass28.getMyclass115()!=null && MyClass28.getMyclass115().getId()!=null && MyClass28.getMyclass115().getId() == 0)
			MyClass28.setMyclass115(null);
		
		
		this.myClass28Service.save(MyClass28);
		session.setComplete();
		return "redirect:/myclass28/list";	
	}


}
