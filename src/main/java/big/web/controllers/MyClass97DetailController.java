package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass97;
import java.util.List;
import org.springframework.ui.Model;
import big.services.MyClass97Service;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass97Validator;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass133Service;
import big.domain.MyClass133;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass97.class)
public class MyClass97DetailController
{

	
	@Autowired
	private MyClass133Service myClass133Service;
	
	@Autowired
	private MyClass97Service myClass97Service;
    

	@RequestMapping(value = "/myclass97/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass97/edit";	
	}

	@RequestMapping(value = "/myclass97/detail/{myClass97Id}")
	public String details (@PathVariable(value = "myClass97Id") Long myClass97Id, Model model) 
	{
		MyClass97 myClass97 = this.myClass97Service.findById(myClass97Id);
		model.addAttribute(myClass97);
		return "myclass97/detail";	
	}

	@RequestMapping(value = "/myclass97/edit/{myClass97Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass97Id") Long myClass97Id, Model model) 
	{
		MyClass97 myClass97 = this.myClass97Service.findById(myClass97Id);
		model.addAttribute(myClass97);
		return "myclass97/edit";	
	}

	@ModelAttribute(value = "myclass133s")
	public List<MyClass133> getMyClass133s () 
	{
		return this.myClass133Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass97Validator());	
	}

	@RequestMapping(value = "/myclass97/edit", method = RequestMethod.GET)
	public MyClass97 newMyClass97 (Model model) 
	{
		if(model != null && model.asMap().get("myclass97") == null)
		{
			return new MyClass97();	
		}
		return (MyClass97) model.asMap().get("myclass97");	
	}

	@RequestMapping(value = {"/myclass97/edit", "/myclass97/edit/{myclass97Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass97 MyClass97, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass97/edit";
		}
		
		if (MyClass97.getMyclass133()!=null && MyClass97.getMyclass133().getId()!=null && MyClass97.getMyclass133().getId() == 0)
			MyClass97.setMyclass133(null);
		
		
		this.myClass97Service.save(MyClass97);
		session.setComplete();
		return "redirect:/myclass97/list";	
	}


}
