package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass;
import big.domain.MyClass4;
import big.services.MyClassService;
import org.springframework.web.bind.support.SessionStatus;
import java.util.List;
import big.web.controllers.validator.MyClass4Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.services.MyClass4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;


@Controller
@SessionAttributes(types = MyClass4.class)
public class MyClass4DetailController
{

	
	@Autowired
	private MyClass4Service myClass4Service;
	
	@Autowired
	private MyClassService myClassService;
    

	@RequestMapping(value = "/myclass4/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass4/edit";	
	}

	@RequestMapping(value = "/myclass4/detail/{myClass4Id}")
	public String details (@PathVariable(value = "myClass4Id") Long myClass4Id, Model model) 
	{
		MyClass4 myClass4 = this.myClass4Service.findById(myClass4Id);
		model.addAttribute(myClass4);
		return "myclass4/detail";	
	}

	@RequestMapping(value = "/myclass4/edit/{myClass4Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass4Id") Long myClass4Id, Model model) 
	{
		MyClass4 myClass4 = this.myClass4Service.findById(myClass4Id);
		model.addAttribute(myClass4);
		return "myclass4/edit";	
	}

	@ModelAttribute(value = "myclasss")
	public List<MyClass> getMyClasss () 
	{
		return this.myClassService.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass4Validator());	
	}

	@RequestMapping(value = "/myclass4/edit", method = RequestMethod.GET)
	public MyClass4 newMyClass4 (Model model) 
	{
		if(model != null && model.asMap().get("myclass4") == null)
		{
			return new MyClass4();	
		}
		return (MyClass4) model.asMap().get("myclass4");	
	}

	@RequestMapping(value = {"/myclass4/edit", "/myclass4/edit/{myclass4Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass4 MyClass4, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass4/edit";
		}
		
		if (MyClass4.getMyclass()!=null && MyClass4.getMyclass().getId()!=null && MyClass4.getMyclass().getId() == 0)
			MyClass4.setMyclass(null);
		
		
		this.myClass4Service.save(MyClass4);
		session.setComplete();
		return "redirect:/myclass4/list";	
	}


}
