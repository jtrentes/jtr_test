package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass163;
import org.springframework.web.bind.support.SessionStatus;
import java.util.List;
import big.services.MyClass28Service;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass163Validator;
import big.services.MyClass163Service;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass28;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass163.class)
public class MyClass163DetailController
{

	
	@Autowired
	private MyClass163Service myClass163Service;
	
	@Autowired
	private MyClass28Service myClass28Service;
    

	@RequestMapping(value = "/myclass163/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass163/edit";	
	}

	@RequestMapping(value = "/myclass163/detail/{myClass163Id}")
	public String details (@PathVariable(value = "myClass163Id") Long myClass163Id, Model model) 
	{
		MyClass163 myClass163 = this.myClass163Service.findById(myClass163Id);
		model.addAttribute(myClass163);
		return "myclass163/detail";	
	}

	@RequestMapping(value = "/myclass163/edit/{myClass163Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass163Id") Long myClass163Id, Model model) 
	{
		MyClass163 myClass163 = this.myClass163Service.findById(myClass163Id);
		model.addAttribute(myClass163);
		return "myclass163/edit";	
	}

	@ModelAttribute(value = "myclass28s")
	public List<MyClass28> getMyClass28s () 
	{
		return this.myClass28Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass163Validator());	
	}

	@RequestMapping(value = "/myclass163/edit", method = RequestMethod.GET)
	public MyClass163 newMyClass163 (Model model) 
	{
		if(model != null && model.asMap().get("myclass163") == null)
		{
			return new MyClass163();	
		}
		return (MyClass163) model.asMap().get("myclass163");	
	}

	@RequestMapping(value = {"/myclass163/edit", "/myclass163/edit/{myclass163Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass163 MyClass163, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass163/edit";
		}
		
		if (MyClass163.getMyclass28()!=null && MyClass163.getMyclass28().getId()!=null && MyClass163.getMyclass28().getId() == 0)
			MyClass163.setMyclass28(null);
		
		
		this.myClass163Service.save(MyClass163);
		session.setComplete();
		return "redirect:/myclass163/list";	
	}


}
