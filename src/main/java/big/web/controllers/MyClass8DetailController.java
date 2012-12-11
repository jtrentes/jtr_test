package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass7;
import big.web.controllers.validator.MyClass8Validator;
import big.services.MyClass8Service;
import big.services.MyClass7Service;
import big.domain.MyClass8;
import java.util.List;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass8.class)
public class MyClass8DetailController
{

	
	@Autowired
	private MyClass7Service myClass7Service;
	
	@Autowired
	private MyClass8Service myClass8Service;
    

	@RequestMapping(value = "/myclass8/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass8/edit";	
	}

	@RequestMapping(value = "/myclass8/detail/{myClass8Id}")
	public String details (@PathVariable(value = "myClass8Id") Long myClass8Id, Model model) 
	{
		MyClass8 myClass8 = this.myClass8Service.findById(myClass8Id);
		model.addAttribute(myClass8);
		return "myclass8/detail";	
	}

	@RequestMapping(value = "/myclass8/edit/{myClass8Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass8Id") Long myClass8Id, Model model) 
	{
		MyClass8 myClass8 = this.myClass8Service.findById(myClass8Id);
		model.addAttribute(myClass8);
		return "myclass8/edit";	
	}

	@ModelAttribute(value = "myclass7s")
	public List<MyClass7> getMyClass7s () 
	{
		return this.myClass7Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass8Validator());	
	}

	@RequestMapping(value = "/myclass8/edit", method = RequestMethod.GET)
	public MyClass8 newMyClass8 (Model model) 
	{
		if(model != null && model.asMap().get("myclass8") == null)
		{
			return new MyClass8();	
		}
		return (MyClass8) model.asMap().get("myclass8");	
	}

	@RequestMapping(value = {"/myclass8/edit", "/myclass8/edit/{myclass8Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass8 MyClass8, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass8/edit";
		}
		
		if (MyClass8.getMyclass7()!=null && MyClass8.getMyclass7().getId()!=null && MyClass8.getMyclass7().getId() == 0)
			MyClass8.setMyclass7(null);
		
		
		this.myClass8Service.save(MyClass8);
		session.setComplete();
		return "redirect:/myclass8/list";	
	}


}
