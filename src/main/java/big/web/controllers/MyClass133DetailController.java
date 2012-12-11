package big.web.controllers;

import org.springframework.web.bind.annotation.RequestMethod;
import big.services.MyClass5Service;
import big.web.controllers.validator.MyClass133Validator;
import org.springframework.web.bind.support.SessionStatus;
import big.domain.MyClass5;
import java.util.List;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.ui.Model;
import big.domain.MyClass133;
import big.services.MyClass133Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;


@Controller
@SessionAttributes(types = MyClass133.class)
public class MyClass133DetailController
{

	
	@Autowired
	private MyClass133Service myClass133Service;
	
	@Autowired
	private MyClass5Service myClass5Service;
    

	@RequestMapping(value = "/myclass133/edit/cancel", method = RequestMethod.GET)
	public String cancel (SessionStatus session) 
	{
		session.setComplete();
		return "redirect:/myclass133/edit";	
	}

	@RequestMapping(value = "/myclass133/detail/{myClass133Id}")
	public String details (@PathVariable(value = "myClass133Id") Long myClass133Id, Model model) 
	{
		MyClass133 myClass133 = this.myClass133Service.findById(myClass133Id);
		model.addAttribute(myClass133);
		return "myclass133/detail";	
	}

	@RequestMapping(value = "/myclass133/edit/{myClass133Id}", method = RequestMethod.GET)
	public String edit (@PathVariable(value = "myClass133Id") Long myClass133Id, Model model) 
	{
		MyClass133 myClass133 = this.myClass133Service.findById(myClass133Id);
		model.addAttribute(myClass133);
		return "myclass133/edit";	
	}

	@ModelAttribute(value = "myclass5s")
	public List<MyClass5> getMyClass5s () 
	{
		return this.myClass5Service.findAll();	
	}

	@InitBinder
	public void initBinder (WebDataBinder binder) 
	{
		binder.setDisallowedFields("id");
		binder.setValidator(new MyClass133Validator());	
	}

	@RequestMapping(value = "/myclass133/edit", method = RequestMethod.GET)
	public MyClass133 newMyClass133 (Model model) 
	{
		if(model != null && model.asMap().get("myclass133") == null)
		{
			return new MyClass133();	
		}
		return (MyClass133) model.asMap().get("myclass133");	
	}

	@RequestMapping(value = {"/myclass133/edit", "/myclass133/edit/{myclass133Id}"}, method = {RequestMethod.POST, RequestMethod.PUT})
	public String save (@Validated @ModelAttribute MyClass133 MyClass133, BindingResult result, SessionStatus session) 
	{
		if(result.hasErrors())
		{
			return "myclass133/edit";
		}
		
		if (MyClass133.getMyclass5()!=null && MyClass133.getMyclass5().getId()!=null && MyClass133.getMyclass5().getId() == 0)
			MyClass133.setMyclass5(null);
		
		
		this.myClass133Service.save(MyClass133);
		session.setComplete();
		return "redirect:/myclass133/list";	
	}


}
