package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass63Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass63;
import big.domain.MyClass8;
import java.util.List;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass63Validator;
import big.services.MyClass8Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass63.class)
public class MyClass63DetailController
{

	
	@Autowired
	private MyClass63Service myClass63Service;
	
	@Autowired
	private MyClass8Service myClass8Service;
    

	@RequestMapping(value = "/myclass63/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass63/edit";	
	}

	@RequestMapping(value = "/myclass63/detail/{myClass63Id}")
	public String details (@PathVariable(value = "myClass63Id") Long myClass63Id, Model model) 
	{
		MyClass63 myClass63 = this.myClass63Service.findById(myClass63Id);
		model.addAttribute(myClass63);
		return "myclass63/detail";	
	}

	@RequestMapping(value = "/myclass63/edit/{myClass63Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass63Id") Long myClass63Id, Model model) 
	{
		MyClass63 myClass63 = this.myClass63Service.findById(myClass63Id);
		model.addAttribute(myClass63);
		return "myclass63/edit";	
	}

	@ModelAttribute(value = "myclass8s")
	public List<MyClass8> getMyClass8s () 
	{
		return this.myClass8Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass63Validator());	
	}

	@RequestMapping(value = "/myclass63/edit", method = RequestMethod.GET)
	public MyClass63 newMyClass63 (Model model) 
	{
		if(model != null && model.asMap().get("myclass63") == null)
		{
			return new MyClass63();	
		}
		return (MyClass63) model.asMap().get("myclass63");	
	}

	@RequestMapping(value = {"/myclass63/edit", "/myclass63/edit/{myclass63Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass63 MyClass63, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass63/edit";
		}
		
		if (MyClass63.getMyclass8()!=null && MyClass63.getMyclass8().getId()!=null && MyClass63.getMyclass8().getId() == 0)
			MyClass63.setMyclass8(null);
		
		
		this.myClass63Service.save(MyClass63);
		session.setComplete();
		return "redirect:/myclass63/list";	
	}


}
