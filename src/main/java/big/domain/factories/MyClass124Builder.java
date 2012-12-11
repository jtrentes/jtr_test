package big.domain.factories;

import big.domain.MyClass124;



public class MyClass124Builder
{

	
	
	private MyClass124 myclass124;
    

	
	public MyClass124 build () 
	{
		return myclass124;	
	}

	
	public MyClass124Builder id (Long id) 
	{
		myclass124.setId (id);
		return this;	
	}

	
	public MyClass124Builder initMyClass124 () 
	{
		myclass124 = new MyClass124();
		return this;	
	}


}
