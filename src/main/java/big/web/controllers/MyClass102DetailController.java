package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass102Validator;
import big.services.MyClass111Service;
import org.springframework.validation.BindingResult;
import big.services.MyClass102Service;
import big.domain.MyClass102;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass111;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass102.class)
public class MyClass102DetailController
{

	
	@Autowired
	private MyClass102Service myClass102Service;
	
	@Autowired
	private MyClass111Service myClass111Service;
    

	@RequestMapping(value = "/myclass102/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass102/edit";	
	}

	@RequestMapping(value = "/myclass102/detail/{myClass102Id}")
	public String details (@PathVariable(value = "myClass102Id") Long myClass102Id, Model model) 
	{
		MyClass102 myClass102 = this.myClass102Service.findById(myClass102Id);
		model.addAttribute(myClass102);
		return "myclass102/detail";	
	}

	@RequestMapping(value = "/myclass102/edit/{myClass102Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass102Id") Long myClass102Id, Model model) 
	{
		MyClass102 myClass102 = this.myClass102Service.findById(myClass102Id);
		model.addAttribute(myClass102);
		return "myclass102/edit";	
	}

	@ModelAttribute(value = "myclass111s")
	public List<MyClass111> getMyClass111s () 
	{
		return this.myClass111Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass102Validator());	
	}

	@RequestMapping(value = "/myclass102/edit", method = RequestMethod.GET)
	public MyClass102 newMyClass102 (Model model) 
	{
		if(model != null && model.asMap().get("myclass102") == null)
		{
			return new MyClass102();	
		}
		return (MyClass102) model.asMap().get("myclass102");	
	}

	@RequestMapping(value = {"/myclass102/edit", "/myclass102/edit/{myclass102Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass102 MyClass102, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass102/edit";
		}
		
		if (MyClass102.getMyclass111()!=null && MyClass102.getMyclass111().getId()!=null && MyClass102.getMyclass111().getId() == 0)
			MyClass102.setMyclass111(null);
		
		
		this.myClass102Service.save(MyClass102);
		session.setComplete();
		return "redirect:/myclass102/list";	
	}


}
