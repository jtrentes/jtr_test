package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.services.MyClass109Service;
import org.springframework.validation.BindingResult;
import big.domain.MyClass109;
import big.web.controllers.validator.MyClass109Validator;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass109.class)
public class MyClass109DetailController
{

	
	@Autowired
	private MyClass109Service myClass109Service;
    

	@RequestMapping(value = "/myclass109/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass109/edit";	
	}

	@RequestMapping(value = "/myclass109/detail/{myClass109Id}")
	public String details (@PathVariable(value = "myClass109Id") Long myClass109Id, Model model) 
	{
		MyClass109 myClass109 = this.myClass109Service.findById(myClass109Id);
		model.addAttribute(myClass109);
		return "myclass109/detail";	
	}

	@RequestMapping(value = "/myclass109/edit/{myClass109Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass109Id") Long myClass109Id, Model model) 
	{
		MyClass109 myClass109 = this.myClass109Service.findById(myClass109Id);
		model.addAttribute(myClass109);
		return "myclass109/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass109Validator());	
	}

	@RequestMapping(value = "/myclass109/edit", method = RequestMethod.GET)
	public MyClass109 newMyClass109 (Model model) 
	{
		if(model != null && model.asMap().get("myclass109") == null)
		{
			return new MyClass109();	
		}
		return (MyClass109) model.asMap().get("myclass109");	
	}

	@RequestMapping(value = {"/myclass109/edit", "/myclass109/edit/{myclass109Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass109 MyClass109, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass109/edit";
		}
		
		
		
		this.myClass109Service.save(MyClass109);
		session.setComplete();
		return "redirect:/myclass109/list";	
	}


}
