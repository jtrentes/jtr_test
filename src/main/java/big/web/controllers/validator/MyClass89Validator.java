package big.web.controllers.validator;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import java.lang.Class;
import java.lang.Object;



public class MyClass89Validator implements Validator
{

    

	
	public boolean supports (Class<?> classz) 
	{
		return true;	
	}

	
	public void validate (Object target, Errors errors) 
	{
			
	}


}
