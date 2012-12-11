package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass129;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass129Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass129Validator;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass129.class)
public class MyClass129DetailController
{

	
	@Autowired
	private MyClass129Service myClass129Service;
    

	@RequestMapping(value = "/myclass129/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass129/edit";	
	}

	@RequestMapping(value = "/myclass129/detail/{myClass129Id}")
	public String details (@PathVariable(value = "myClass129Id") Long myClass129Id, Model model) 
	{
		MyClass129 myClass129 = this.myClass129Service.findById(myClass129Id);
		model.addAttribute(myClass129);
		return "myclass129/detail";	
	}

	@RequestMapping(value = "/myclass129/edit/{myClass129Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass129Id") Long myClass129Id, Model model) 
	{
		MyClass129 myClass129 = this.myClass129Service.findById(myClass129Id);
		model.addAttribute(myClass129);
		return "myclass129/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass129Validator());	
	}

	@RequestMapping(value = "/myclass129/edit", method = RequestMethod.GET)
	public MyClass129 newMyClass129 (Model model) 
	{
		if(model != null && model.asMap().get("myclass129") == null)
		{
			return new MyClass129();	
		}
		return (MyClass129) model.asMap().get("myclass129");	
	}

	@RequestMapping(value = {"/myclass129/edit", "/myclass129/edit/{myclass129Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass129 MyClass129, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass129/edit";
		}
		
		
		
		this.myClass129Service.save(MyClass129);
		session.setComplete();
		return "redirect:/myclass129/list";	
	}


}
