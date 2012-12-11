package big.web.controllers.validator;

import java.lang.Object;
import org.springframework.validation.Validator;
import java.lang.Class;
import org.springframework.validation.Errors;



public class MyClass152Validator implements Validator
{

    

	
	public boolean supports (Class<?> classz) 
	{
		return true;	
	}

	
	public void validate (Object target, Errors errors) 
	{
			
	}


}
