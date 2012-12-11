package big.domain.factories;

import big.domain.MyClass67;



public class MyClass67Builder
{

	
	
	private MyClass67 myclass67;
    

	
	public MyClass67 build () 
	{
		return myclass67;	
	}

	
	public MyClass67Builder id (Long id) 
	{
		myclass67.setId (id);
		return this;	
	}

	
	public MyClass67Builder initMyClass67 () 
	{
		myclass67 = new MyClass67();
		return this;	
	}


}
