package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.domain.MyClass;
import big.domain.MyClass2;
import org.springframework.web.bind.WebDataBinder;
import java.util.List;
import big.services.MyClassService;
import big.services.MyClass2Service;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.ui.Model;
import big.web.controllers.validator.MyClassValidator;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(types = MyClass.class)
public class MyClassDetailController
{

	
	@Autowired
	private MyClass2Service myClass2Service;
	
	@Autowired
	private MyClassService myClassService;
    

	@RequestMapping(value = "/myclass/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass/edit";	
	}

	@RequestMapping(value = "/myclass/detail/{myClassId}")
	public String details (@PathVariable(value = "myClassId") Long myClassId, Model model) 
	{
		MyClass myClass = this.myClassService.findById(myClassId);
		model.addAttribute(myClass);
		return "myclass/detail";	
	}

	@RequestMapping(value = "/myclass/edit/{myClassId}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClassId") Long myClassId, Model model) 
	{
		MyClass myClass = this.myClassService.findById(myClassId);
		model.addAttribute(myClass);
		return "myclass/edit";	
	}

	@ModelAttribute(value = "myclass2s")
	public List<MyClass2> getMyClass2s () 
	{
		return this.myClass2Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClassValidator());	
	}

	@RequestMapping(value = "/myclass/edit", method = RequestMethod.GET)
	public MyClass newMyClass (Model model) 
	{
		if(model != null && model.asMap().get("myclass") == null)
		{
			return new MyClass();	
		}
		return (MyClass) model.asMap().get("myclass");	
	}

	@RequestMapping(value = {"/myclass/edit", "/myclass/edit/{myclassId}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass MyClass, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass/edit";
		}
		
		if (MyClass.getMyclass2()!=null && MyClass.getMyclass2().getId()!=null && MyClass.getMyclass2().getId() == 0)
			MyClass.setMyclass2(null);
		
		
		this.myClassService.save(MyClass);
		session.setComplete();
		return "redirect:/myclass/list";	
	}


}
