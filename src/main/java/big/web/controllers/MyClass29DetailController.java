package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass29Service;
import big.domain.MyClass29;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass29Validator;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass29.class)
public class MyClass29DetailController
{

	
	@Autowired
	private MyClass29Service myClass29Service;
    

	@RequestMapping(value = "/myclass29/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass29/edit";	
	}

	@RequestMapping(value = "/myclass29/detail/{myClass29Id}")
	public String details (@PathVariable(value = "myClass29Id") Long myClass29Id, Model model) 
	{
		MyClass29 myClass29 = this.myClass29Service.findById(myClass29Id);
		model.addAttribute(myClass29);
		return "myclass29/detail";	
	}

	@RequestMapping(value = "/myclass29/edit/{myClass29Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass29Id") Long myClass29Id, Model model) 
	{
		MyClass29 myClass29 = this.myClass29Service.findById(myClass29Id);
		model.addAttribute(myClass29);
		return "myclass29/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass29Validator());	
	}

	@RequestMapping(value = "/myclass29/edit", method = RequestMethod.GET)
	public MyClass29 newMyClass29 (Model model) 
	{
		if(model != null && model.asMap().get("myclass29") == null)
		{
			return new MyClass29();	
		}
		return (MyClass29) model.asMap().get("myclass29");	
	}

	@RequestMapping(value = {"/myclass29/edit", "/myclass29/edit/{myclass29Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass29 MyClass29, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass29/edit";
		}
		
		
		
		this.myClass29Service.save(MyClass29);
		session.setComplete();
		return "redirect:/myclass29/list";	
	}


}
