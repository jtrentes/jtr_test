package big.web.controllers.validator;

import java.lang.Class;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.lang.Object;



public class MyClass33Validator implements Validator
{

    

	
	public boolean supports (Class<?> classz) 
	{
		return true;	
	}

	
	public void validate (Object target, Errors errors) 
	{
			
	}


}
