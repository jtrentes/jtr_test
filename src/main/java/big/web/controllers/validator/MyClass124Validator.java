package big.web.controllers.validator;

import org.springframework.validation.Validator;
import java.lang.Class;
import java.lang.Object;
import org.springframework.validation.Errors;



public class MyClass124Validator implements Validator
{

    

	
	public boolean supports (Class<?> classz) 
	{
		return true;	
	}

	
	public void validate (Object target, Errors errors) 
	{
			
	}


}
