package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass25Service;
import org.springframework.web.bind.WebDataBinder;
import big.domain.MyClass25;
import big.services.MyClass57Service;
import java.util.List;
import big.domain.MyClass57;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClass25Validator;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass25.class)
public class MyClass25DetailController
{

	
	@Autowired
	private MyClass25Service myClass25Service;
	
	@Autowired
	private MyClass57Service myClass57Service;
    

	@RequestMapping(value = "/myclass25/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass25/edit";	
	}

	@RequestMapping(value = "/myclass25/detail/{myClass25Id}")
	public String details (@PathVariable(value = "myClass25Id") Long myClass25Id, Model model) 
	{
		MyClass25 myClass25 = this.myClass25Service.findById(myClass25Id);
		model.addAttribute(myClass25);
		return "myclass25/detail";	
	}

	@RequestMapping(value = "/myclass25/edit/{myClass25Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass25Id") Long myClass25Id, Model model) 
	{
		MyClass25 myClass25 = this.myClass25Service.findById(myClass25Id);
		model.addAttribute(myClass25);
		return "myclass25/edit";	
	}

	@ModelAttribute(value = "myclass57s")
	public List<MyClass57> getMyClass57s () 
	{
		return this.myClass57Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass25Validator());	
	}

	@RequestMapping(value = "/myclass25/edit", method = RequestMethod.GET)
	public MyClass25 newMyClass25 (Model model) 
	{
		if(model != null && model.asMap().get("myclass25") == null)
		{
			return new MyClass25();	
		}
		return (MyClass25) model.asMap().get("myclass25");	
	}

	@RequestMapping(value = {"/myclass25/edit", "/myclass25/edit/{myclass25Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass25 MyClass25, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass25/edit";
		}
		
		if (MyClass25.getMyclass57()!=null && MyClass25.getMyclass57().getId()!=null && MyClass25.getMyclass57().getId() == 0)
			MyClass25.setMyclass57(null);
		
		
		this.myClass25Service.save(MyClass25);
		session.setComplete();
		return "redirect:/myclass25/list";	
	}


}
