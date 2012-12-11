package big.domain.factories;

import big.domain.MyClass146;



public class MyClass146Builder
{

	
	
	private MyClass146 myclass146;
    

	
	public MyClass146 build () 
	{
		return myclass146;	
	}

	
	public MyClass146Builder id (Long id) 
	{
		myclass146.setId (id);
		return this;	
	}

	
	public MyClass146Builder initMyClass146 () 
	{
		myclass146 = new MyClass146();
		return this;	
	}


}
