package big.domain.factories;

import big.domain.MyClass55;



public class MyClass55Builder
{

	
	
	private MyClass55 myclass55;
    

	
	public MyClass55 build () 
	{
		return myclass55;	
	}

	
	public MyClass55Builder id (Long id) 
	{
		myclass55.setId (id);
		return this;	
	}

	
	public MyClass55Builder initMyClass55 () 
	{
		myclass55 = new MyClass55();
		return this;	
	}


}
