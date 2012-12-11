package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass10Validator;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.services.MyClass10Service;
import org.springframework.validation.BindingResult;
import big.domain.MyClass10;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass10.class)
public class MyClass10DetailController
{

	
	@Autowired
	private MyClass10Service myClass10Service;
    

	@RequestMapping(value = "/myclass10/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass10/edit";	
	}

	@RequestMapping(value = "/myclass10/detail/{myClass10Id}")
	public String details (@PathVariable(value = "myClass10Id") Long myClass10Id, Model model) 
	{
		MyClass10 myClass10 = this.myClass10Service.findById(myClass10Id);
		model.addAttribute(myClass10);
		return "myclass10/detail";	
	}

	@RequestMapping(value = "/myclass10/edit/{myClass10Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass10Id") Long myClass10Id, Model model) 
	{
		MyClass10 myClass10 = this.myClass10Service.findById(myClass10Id);
		model.addAttribute(myClass10);
		return "myclass10/edit";	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass10Validator());	
	}

	@RequestMapping(value = "/myclass10/edit", method = RequestMethod.GET)
	public MyClass10 newMyClass10 (Model model) 
	{
		if(model != null && model.asMap().get("myclass10") == null)
		{
			return new MyClass10();	
		}
		return (MyClass10) model.asMap().get("myclass10");	
	}

	@RequestMapping(value = {"/myclass10/edit", "/myclass10/edit/{myclass10Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass10 MyClass10, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass10/edit";
		}
		
		
		
		this.myClass10Service.save(MyClass10);
		session.setComplete();
		return "redirect:/myclass10/list";	
	}


}
