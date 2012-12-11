package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass35;
import big.domain.MyClass51;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass35Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass35Validator;
import big.services.MyClass51Service;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass35.class)
public class MyClass35DetailController
{

	
	@Autowired
	private MyClass35Service myClass35Service;
	
	@Autowired
	private MyClass51Service myClass51Service;
    

	@RequestMapping(value = "/myclass35/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass35/edit";	
	}

	@RequestMapping(value = "/myclass35/detail/{myClass35Id}")
	public String details (@PathVariable(value = "myClass35Id") Long myClass35Id, Model model) 
	{
		MyClass35 myClass35 = this.myClass35Service.findById(myClass35Id);
		model.addAttribute(myClass35);
		return "myclass35/detail";	
	}

	@RequestMapping(value = "/myclass35/edit/{myClass35Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass35Id") Long myClass35Id, Model model) 
	{
		MyClass35 myClass35 = this.myClass35Service.findById(myClass35Id);
		model.addAttribute(myClass35);
		return "myclass35/edit";	
	}

	@ModelAttribute(value = "myclass51s")
	public List<MyClass51> getMyClass51s () 
	{
		return this.myClass51Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass35Validator());	
	}

	@RequestMapping(value = "/myclass35/edit", method = RequestMethod.GET)
	public MyClass35 newMyClass35 (Model model) 
	{
		if(model != null && model.asMap().get("myclass35") == null)
		{
			return new MyClass35();	
		}
		return (MyClass35) model.asMap().get("myclass35");	
	}

	@RequestMapping(value = {"/myclass35/edit", "/myclass35/edit/{myclass35Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass35 MyClass35, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass35/edit";
		}
		
		if (MyClass35.getMyclass51()!=null && MyClass35.getMyclass51().getId()!=null && MyClass35.getMyclass51().getId() == 0)
			MyClass35.setMyclass51(null);
		
		
		this.myClass35Service.save(MyClass35);
		session.setComplete();
		return "redirect:/myclass35/list";	
	}


}
