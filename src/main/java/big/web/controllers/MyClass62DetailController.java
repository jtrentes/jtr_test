package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import big.services.MyClass63Service;
import big.domain.MyClass62;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass62Service;
import big.domain.MyClass35;
import big.domain.MyClass63;
import org.springframework.web.bind.WebDataBinder;
import big.web.controllers.validator.MyClass62Validator;
import org.springframework.validation.BindingResult;
import big.services.MyClass35Service;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
@SessionAttributes(types = MyClass62.class)
public class MyClass62DetailController
{

	
	@Autowired
	private MyClass35Service myClass35Service;
	
	@Autowired
	private MyClass62Service myClass62Service;
	
	@Autowired
	private MyClass63Service myClass63Service;
    

	@RequestMapping(value = "/myclass62/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass62/edit";	
	}

	@RequestMapping(value = "/myclass62/detail/{myClass62Id}")
	public String details (@PathVariable(value = "myClass62Id") Long myClass62Id, Model model) 
	{
		MyClass62 myClass62 = this.myClass62Service.findById(myClass62Id);
		model.addAttribute(myClass62);
		return "myclass62/detail";	
	}

	@RequestMapping(value = "/myclass62/edit/{myClass62Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass62Id") Long myClass62Id, Model model) 
	{
		MyClass62 myClass62 = this.myClass62Service.findById(myClass62Id);
		model.addAttribute(myClass62);
		return "myclass62/edit";	
	}

	@ModelAttribute(value = "myclass35s")
	public List<MyClass35> getMyClass35s () 
	{
		return this.myClass35Service.findAll();	
	}

	@ModelAttribute(value = "myclass63s")
	public List<MyClass63> getMyClass63s () 
	{
		return this.myClass63Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass62Validator());	
	}

	@RequestMapping(value = "/myclass62/edit", method = RequestMethod.GET)
	public MyClass62 newMyClass62 (Model model) 
	{
		if(model != null && model.asMap().get("myclass62") == null)
		{
			return new MyClass62();	
		}
		return (MyClass62) model.asMap().get("myclass62");	
	}

	@RequestMapping(value = {"/myclass62/edit", "/myclass62/edit/{myclass62Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass62 MyClass62, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass62/edit";
		}
		
		if (MyClass62.getMyclass63()!=null && MyClass62.getMyclass63().getId()!=null && MyClass62.getMyclass63().getId() == 0)
			MyClass62.setMyclass63(null);
		if (MyClass62.getMyclass35()!=null && MyClass62.getMyclass35().getId()!=null && MyClass62.getMyclass35().getId() == 0)
			MyClass62.setMyclass35(null);
		
		
		this.myClass62Service.save(MyClass62);
		session.setComplete();
		return "redirect:/myclass62/list";	
	}


}
