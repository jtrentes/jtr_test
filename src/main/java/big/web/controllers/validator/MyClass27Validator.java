package big.web.controllers.validator;

import java.lang.Object;
import java.lang.Class;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;



public class MyClass27Validator implements Validator
{

    

	
	public boolean supports (Class<?> classz) 
	{
		return true;	
	}

	
	public void validate (Object target, Errors errors) 
	{
			
	}


}
