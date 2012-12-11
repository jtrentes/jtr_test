package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass45Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass54Service;
import big.domain.MyClass46;
import org.springframework.ui.Model;
import big.domain.MyClass54;
import big.web.controllers.validator.MyClass45Validator;
import big.domain.MyClass45;
import java.util.List;
import big.services.MyClass46Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass45.class)
public class MyClass45DetailController
{

	
	@Autowired
	private MyClass45Service myClass45Service;
	
	@Autowired
	private MyClass46Service myClass46Service;
	
	@Autowired
	private MyClass54Service myClass54Service;
    

	@RequestMapping(value = "/myclass45/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass45/edit";	
	}

	@RequestMapping(value = "/myclass45/detail/{myClass45Id}")
	public String details (@PathVariable(value = "myClass45Id") Long myClass45Id, Model model) 
	{
		MyClass45 myClass45 = this.myClass45Service.findById(myClass45Id);
		model.addAttribute(myClass45);
		return "myclass45/detail";	
	}

	@RequestMapping(value = "/myclass45/edit/{myClass45Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass45Id") Long myClass45Id, Model model) 
	{
		MyClass45 myClass45 = this.myClass45Service.findById(myClass45Id);
		model.addAttribute(myClass45);
		return "myclass45/edit";	
	}

	@ModelAttribute(value = "myclass46s")
	public List<MyClass46> getMyClass46s () 
	{
		return this.myClass46Service.findAll();	
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
		binder.setValidator(new MyClass45Validator());	
	}

	@RequestMapping(value = "/myclass45/edit", method = RequestMethod.GET)
	public MyClass45 newMyClass45 (Model model) 
	{
		if(model != null && model.asMap().get("myclass45") == null)
		{
			return new MyClass45();	
		}
		return (MyClass45) model.asMap().get("myclass45");	
	}

	@RequestMapping(value = {"/myclass45/edit", "/myclass45/edit/{myclass45Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass45 MyClass45, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass45/edit";
		}
		
		if (MyClass45.getMyclass54()!=null && MyClass45.getMyclass54().getId()!=null && MyClass45.getMyclass54().getId() == 0)
			MyClass45.setMyclass54(null);
		if (MyClass45.getMyclass46()!=null && MyClass45.getMyclass46().getId()!=null && MyClass45.getMyclass46().getId() == 0)
			MyClass45.setMyclass46(null);
		
		
		this.myClass45Service.save(MyClass45);
		session.setComplete();
		return "redirect:/myclass45/list";	
	}


}
