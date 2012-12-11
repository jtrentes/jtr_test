package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import big.domain.MyClass30;
import big.domain.MyClass46;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass30Service;
import big.web.controllers.validator.MyClass46Validator;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass46Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass46.class)
public class MyClass46DetailController
{

	
	@Autowired
	private MyClass30Service myClass30Service;
	
	@Autowired
	private MyClass46Service myClass46Service;
    

	@RequestMapping(value = "/myclass46/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass46/edit";	
	}

	@RequestMapping(value = "/myclass46/detail/{myClass46Id}")
	public String details (@PathVariable(value = "myClass46Id") Long myClass46Id, Model model) 
	{
		MyClass46 myClass46 = this.myClass46Service.findById(myClass46Id);
		model.addAttribute(myClass46);
		return "myclass46/detail";	
	}

	@RequestMapping(value = "/myclass46/edit/{myClass46Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass46Id") Long myClass46Id, Model model) 
	{
		MyClass46 myClass46 = this.myClass46Service.findById(myClass46Id);
		model.addAttribute(myClass46);
		return "myclass46/edit";	
	}

	@ModelAttribute(value = "myclass30s")
	public List<MyClass30> getMyClass30s () 
	{
		return this.myClass30Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass46Validator());	
	}

	@RequestMapping(value = "/myclass46/edit", method = RequestMethod.GET)
	public MyClass46 newMyClass46 (Model model) 
	{
		if(model != null && model.asMap().get("myclass46") == null)
		{
			return new MyClass46();	
		}
		return (MyClass46) model.asMap().get("myclass46");	
	}

	@RequestMapping(value = {"/myclass46/edit", "/myclass46/edit/{myclass46Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass46 MyClass46, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass46/edit";
		}
		
		if (MyClass46.getMyclass30()!=null && MyClass46.getMyclass30().getId()!=null && MyClass46.getMyclass30().getId() == 0)
			MyClass46.setMyclass30(null);
		
		
		this.myClass46Service.save(MyClass46);
		session.setComplete();
		return "redirect:/myclass46/list";	
	}


}
