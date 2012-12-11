package big.web.controllers.validator;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import java.lang.Object;
import java.lang.Class;



public class MyClass19Validator implements Validator
{

    

	
	public boolean supports (Class<?> classz) 
	{
		return true;	
	}

	
	public void validate (Object target, Errors errors) 
	{
			
	}


}
