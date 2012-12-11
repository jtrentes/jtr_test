package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass68Validator;
import big.domain.MyClass68;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass68Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;


@Controller
@SessionAttributes(types = MyClass68.class)
public class MyClass68DetailController
{

	
	@Autowired
	private MyClass68Service myClass68Service;
    

	@RequestMapping(value = "/myclass68/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass68/edit";	
	}

	@RequestMapping(value = "/myclass68/detail/{myClass68Id}")
	public String details (@PathVariable(value = "myClass68Id") Long myClass68Id, Model model) 
	{
		MyClass68 myClass68 = this.myClass68Service.findById(myClass68Id);
		model.addAttribute(myClass68);
		return "myclass68/detail";	
	}

	@RequestMapping(value = "/myclass68/edit/{myClass68Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass68Id") Long myClass68Id, Model model) 
	{
		MyClass68 myClass68 = this.myClass68Service.findById(myClass68Id);
		model.addAttribute(myClass68);
		return "myclass68/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass68Validator());	
	}

	@RequestMapping(value = "/myclass68/edit", method = RequestMethod.GET)
	public MyClass68 newMyClass68 (Model model) 
	{
		if(model != null && model.asMap().get("myclass68") == null)
		{
			return new MyClass68();	
		}
		return (MyClass68) model.asMap().get("myclass68");	
	}

	@RequestMapping(value = {"/myclass68/edit", "/myclass68/edit/{myclass68Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass68 MyClass68, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass68/edit";
		}
		
		
		
		this.myClass68Service.save(MyClass68);
		session.setComplete();
		return "redirect:/myclass68/list";	
	}


}
