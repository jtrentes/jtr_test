package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.web.controllers.validator.MyClass76Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass89Service;
import java.util.List;
import big.domain.MyClass89;
import big.domain.MyClass76;
import org.springframework.ui.Model;
import big.services.MyClass76Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass76.class)
public class MyClass76DetailController
{

	
	@Autowired
	private MyClass76Service myClass76Service;
	
	@Autowired
	private MyClass89Service myClass89Service;
    

	@RequestMapping(value = "/myclass76/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass76/edit";	
	}

	@RequestMapping(value = "/myclass76/detail/{myClass76Id}")
	public String details (@PathVariable(value = "myClass76Id") Long myClass76Id, Model model) 
	{
		MyClass76 myClass76 = this.myClass76Service.findById(myClass76Id);
		model.addAttribute(myClass76);
		return "myclass76/detail";	
	}

	@RequestMapping(value = "/myclass76/edit/{myClass76Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass76Id") Long myClass76Id, Model model) 
	{
		MyClass76 myClass76 = this.myClass76Service.findById(myClass76Id);
		model.addAttribute(myClass76);
		return "myclass76/edit";	
	}

	@ModelAttribute(value = "myclass89s")
	public List<MyClass89> getMyClass89s () 
	{
		return this.myClass89Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass76Validator());	
	}

	@RequestMapping(value = "/myclass76/edit", method = RequestMethod.GET)
	public MyClass76 newMyClass76 (Model model) 
	{
		if(model != null && model.asMap().get("myclass76") == null)
		{
			return new MyClass76();	
		}
		return (MyClass76) model.asMap().get("myclass76");	
	}

	@RequestMapping(value = {"/myclass76/edit", "/myclass76/edit/{myclass76Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass76 MyClass76, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass76/edit";
		}
		
		if (MyClass76.getMyclass89()!=null && MyClass76.getMyclass89().getId()!=null && MyClass76.getMyclass89().getId() == 0)
			MyClass76.setMyclass89(null);
		
		
		this.myClass76Service.save(MyClass76);
		session.setComplete();
		return "redirect:/myclass76/list";	
	}


}
