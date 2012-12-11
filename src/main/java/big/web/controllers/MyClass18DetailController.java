package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass153;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass18Validator;
import org.springframework.validation.BindingResult;
import big.domain.MyClass18;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass18Service;
import big.services.MyClass153Service;
import java.util.List;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass18.class)
public class MyClass18DetailController
{

	
	@Autowired
	private MyClass153Service myClass153Service;
	
	@Autowired
	private MyClass18Service myClass18Service;
    

	@RequestMapping(value = "/myclass18/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass18/edit";	
	}

	@RequestMapping(value = "/myclass18/detail/{myClass18Id}")
	public String details (@PathVariable(value = "myClass18Id") Long myClass18Id, Model model) 
	{
		MyClass18 myClass18 = this.myClass18Service.findById(myClass18Id);
		model.addAttribute(myClass18);
		return "myclass18/detail";	
	}

	@RequestMapping(value = "/myclass18/edit/{myClass18Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass18Id") Long myClass18Id, Model model) 
	{
		MyClass18 myClass18 = this.myClass18Service.findById(myClass18Id);
		model.addAttribute(myClass18);
		return "myclass18/edit";	
	}

	@ModelAttribute(value = "myclass153s")
	public List<MyClass153> getMyClass153s () 
	{
		return this.myClass153Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass18Validator());	
	}

	@RequestMapping(value = "/myclass18/edit", method = RequestMethod.GET)
	public MyClass18 newMyClass18 (Model model) 
	{
		if(model != null && model.asMap().get("myclass18") == null)
		{
			return new MyClass18();	
		}
		return (MyClass18) model.asMap().get("myclass18");	
	}

	@RequestMapping(value = {"/myclass18/edit", "/myclass18/edit/{myclass18Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass18 MyClass18, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass18/edit";
		}
		
		if (MyClass18.getMyclass153()!=null && MyClass18.getMyclass153().getId()!=null && MyClass18.getMyclass153().getId() == 0)
			MyClass18.setMyclass153(null);
		
		
		this.myClass18Service.save(MyClass18);
		session.setComplete();
		return "redirect:/myclass18/list";	
	}


}
