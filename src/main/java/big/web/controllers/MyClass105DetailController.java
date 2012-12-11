package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass105Service;
import big.web.controllers.validator.MyClass105Validator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass105;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass105.class)
public class MyClass105DetailController
{

	
	@Autowired
	private MyClass105Service myClass105Service;
    

	@RequestMapping(value = "/myclass105/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass105/edit";	
	}

	@RequestMapping(value = "/myclass105/detail/{myClass105Id}")
	public String details (@PathVariable(value = "myClass105Id") Long myClass105Id, Model model) 
	{
		MyClass105 myClass105 = this.myClass105Service.findById(myClass105Id);
		model.addAttribute(myClass105);
		return "myclass105/detail";	
	}

	@RequestMapping(value = "/myclass105/edit/{myClass105Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass105Id") Long myClass105Id, Model model) 
	{
		MyClass105 myClass105 = this.myClass105Service.findById(myClass105Id);
		model.addAttribute(myClass105);
		return "myclass105/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass105Validator());	
	}

	@RequestMapping(value = "/myclass105/edit", method = RequestMethod.GET)
	public MyClass105 newMyClass105 (Model model) 
	{
		if(model != null && model.asMap().get("myclass105") == null)
		{
			return new MyClass105();	
		}
		return (MyClass105) model.asMap().get("myclass105");	
	}

	@RequestMapping(value = {"/myclass105/edit", "/myclass105/edit/{myclass105Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass105 MyClass105, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass105/edit";
		}
		
		
		
		this.myClass105Service.save(MyClass105);
		session.setComplete();
		return "redirect:/myclass105/list";	
	}


}
