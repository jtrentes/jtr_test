package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import big.web.controllers.validator.MyClass3Validator;
import big.domain.MyClass3;
import big.services.MyClass2Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;
import big.services.MyClass3Service;
import org.springframework.web.bind.WebDataBinder;
import java.util.List;
import big.domain.MyClass2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SessionAttributes(types = MyClass3.class)
public class MyClass3DetailController
{

	
	@Autowired
	private MyClass2Service myClass2Service;
	
	@Autowired
	private MyClass3Service myClass3Service;
    

	@RequestMapping(value = "/myclass3/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass3/edit";	
	}

	@RequestMapping(value = "/myclass3/detail/{myClass3Id}")
	public String details (@PathVariable(value = "myClass3Id") Long myClass3Id, Model model) 
	{
		MyClass3 myClass3 = this.myClass3Service.findById(myClass3Id);
		model.addAttribute(myClass3);
		return "myclass3/detail";	
	}

	@RequestMapping(value = "/myclass3/edit/{myClass3Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass3Id") Long myClass3Id, Model model) 
	{
		MyClass3 myClass3 = this.myClass3Service.findById(myClass3Id);
		model.addAttribute(myClass3);
		return "myclass3/edit";	
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
		binder.setValidator(new MyClass3Validator());	
	}

	@RequestMapping(value = "/myclass3/edit", method = RequestMethod.GET)
	public MyClass3 newMyClass3 (Model model) 
	{
		if(model != null && model.asMap().get("myclass3") == null)
		{
			return new MyClass3();	
		}
		return (MyClass3) model.asMap().get("myclass3");	
	}

	@RequestMapping(value = {"/myclass3/edit", "/myclass3/edit/{myclass3Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass3 MyClass3, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass3/edit";
		}
		
		if (MyClass3.getMyclass2()!=null && MyClass3.getMyclass2().getId()!=null && MyClass3.getMyclass2().getId() == 0)
			MyClass3.setMyclass2(null);
		
		
		this.myClass3Service.save(MyClass3);
		session.setComplete();
		return "redirect:/myclass3/list";	
	}


}
