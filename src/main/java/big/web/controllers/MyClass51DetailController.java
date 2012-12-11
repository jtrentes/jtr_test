package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass17Service;
import org.springframework.validation.BindingResult;
import big.domain.MyClass17;
import big.domain.MyClass51;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass51Validator;
import org.springframework.web.bind.support.SessionStatus;
import java.util.List;
import org.springframework.ui.Model;
import big.services.MyClass51Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@SessionAttributes(types = MyClass51.class)
public class MyClass51DetailController
{

	
	@Autowired
	private MyClass17Service myClass17Service;
	
	@Autowired
	private MyClass51Service myClass51Service;
    

	@RequestMapping(value = "/myclass51/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass51/edit";	
	}

	@RequestMapping(value = "/myclass51/detail/{myClass51Id}")
	public String details (@PathVariable(value = "myClass51Id") Long myClass51Id, Model model) 
	{
		MyClass51 myClass51 = this.myClass51Service.findById(myClass51Id);
		model.addAttribute(myClass51);
		return "myclass51/detail";	
	}

	@RequestMapping(value = "/myclass51/edit/{myClass51Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass51Id") Long myClass51Id, Model model) 
	{
		MyClass51 myClass51 = this.myClass51Service.findById(myClass51Id);
		model.addAttribute(myClass51);
		return "myclass51/edit";	
	}

	@ModelAttribute(value = "myclass17s")
	public List<MyClass17> getMyClass17s () 
	{
		return this.myClass17Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass51Validator());	
	}

	@RequestMapping(value = "/myclass51/edit", method = RequestMethod.GET)
	public MyClass51 newMyClass51 (Model model) 
	{
		if(model != null && model.asMap().get("myclass51") == null)
		{
			return new MyClass51();	
		}
		return (MyClass51) model.asMap().get("myclass51");	
	}

	@RequestMapping(value = {"/myclass51/edit", "/myclass51/edit/{myclass51Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass51 MyClass51, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass51/edit";
		}
		
		if (MyClass51.getMyclass17()!=null && MyClass51.getMyclass17().getId()!=null && MyClass51.getMyclass17().getId() == 0)
			MyClass51.setMyclass17(null);
		
		
		this.myClass51Service.save(MyClass51);
		session.setComplete();
		return "redirect:/myclass51/list";	
	}


}
