package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass54;
import big.web.controllers.validator.MyClass37Validator;
import big.services.MyClass54Service;
import org.springframework.ui.Model;
import java.util.List;
import big.services.MyClass37Service;
import big.domain.MyClass37;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
@SessionAttributes(types = MyClass37.class)
public class MyClass37DetailController
{

	
	@Autowired
	private MyClass37Service myClass37Service;
	
	@Autowired
	private MyClass54Service myClass54Service;
    

	@RequestMapping(value = "/myclass37/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass37/edit";	
	}

	@RequestMapping(value = "/myclass37/detail/{myClass37Id}")
	public String details (@PathVariable(value = "myClass37Id") Long myClass37Id, Model model) 
	{
		MyClass37 myClass37 = this.myClass37Service.findById(myClass37Id);
		model.addAttribute(myClass37);
		return "myclass37/detail";	
	}

	@RequestMapping(value = "/myclass37/edit/{myClass37Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass37Id") Long myClass37Id, Model model) 
	{
		MyClass37 myClass37 = this.myClass37Service.findById(myClass37Id);
		model.addAttribute(myClass37);
		return "myclass37/edit";	
	}

	@ModelAttribute(value = "myclass54s")
	public List<MyClass54> getMyClass54s () 
	{
		return this.myClass54Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass37Validator());	
	}

	@RequestMapping(value = "/myclass37/edit", method = RequestMethod.GET)
	public MyClass37 newMyClass37 (Model model) 
	{
		if(model != null && model.asMap().get("myclass37") == null)
		{
			return new MyClass37();	
		}
		return (MyClass37) model.asMap().get("myclass37");	
	}

	@RequestMapping(value = {"/myclass37/edit", "/myclass37/edit/{myclass37Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass37 MyClass37, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass37/edit";
		}
		
		if (MyClass37.getMyclass54()!=null && MyClass37.getMyclass54().getId()!=null && MyClass37.getMyclass54().getId() == 0)
			MyClass37.setMyclass54(null);
		
		
		this.myClass37Service.save(MyClass37);
		session.setComplete();
		return "redirect:/myclass37/list";	
	}


}
