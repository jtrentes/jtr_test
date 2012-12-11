package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass2;
import big.web.controllers.validator.MyClass2Validator;
import org.springframework.validation.BindingResult;
import big.services.MyClassService;
import org.springframework.web.bind.support.SessionStatus;
import java.util.List;
import org.springframework.ui.Model;
import big.domain.MyClass;
import org.springframework.web.bind.WebDataBinder;
import big.services.MyClass2Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass2.class)
public class MyClass2DetailController
{

	
	@Autowired
	private MyClass2Service myClass2Service;
	
	@Autowired
	private MyClassService myClassService;
    

	@RequestMapping(value = "/myclass2/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass2/edit";	
	}

	@RequestMapping(value = "/myclass2/detail/{myClass2Id}")
	public String details (@PathVariable(value = "myClass2Id") Long myClass2Id, Model model) 
	{
		MyClass2 myClass2 = this.myClass2Service.findById(myClass2Id);
		model.addAttribute(myClass2);
		return "myclass2/detail";	
	}

	@RequestMapping(value = "/myclass2/edit/{myClass2Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass2Id") Long myClass2Id, Model model) 
	{
		MyClass2 myClass2 = this.myClass2Service.findById(myClass2Id);
		model.addAttribute(myClass2);
		return "myclass2/edit";	
	}

	@ModelAttribute(value = "myclasss")
	public List<MyClass> getMyClasss () 
	{
		return this.myClassService.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass2Validator());	
	}

	@RequestMapping(value = "/myclass2/edit", method = RequestMethod.GET)
	public MyClass2 newMyClass2 (Model model) 
	{
		if(model != null && model.asMap().get("myclass2") == null)
		{
			return new MyClass2();	
		}
		return (MyClass2) model.asMap().get("myclass2");	
	}

	@RequestMapping(value = {"/myclass2/edit", "/myclass2/edit/{myclass2Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass2 MyClass2, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass2/edit";
		}
		
		if (MyClass2.getMyclass()!=null && MyClass2.getMyclass().getId()!=null && MyClass2.getMyclass().getId() == 0)
			MyClass2.setMyclass(null);
		
		
		this.myClass2Service.save(MyClass2);
		session.setComplete();
		return "redirect:/myclass2/list";	
	}


}
