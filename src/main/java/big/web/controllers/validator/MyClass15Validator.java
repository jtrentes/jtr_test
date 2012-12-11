package big.web.controllers.validator;

import java.lang.Class;
import java.lang.Object;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class MyClass15Validator implements Validator
{

    

	
	public boolean supports (Class<?> classz) 
	{
		return true;	
	}

	
	public void validate (Object target, Errors errors) 
	{
			
	}


}
