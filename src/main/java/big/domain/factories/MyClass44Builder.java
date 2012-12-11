package big.domain.factories;

import big.domain.MyClass44;



public class MyClass44Builder
{

	
	
	private MyClass44 myclass44;
    

	
	public MyClass44 build () 
	{
		return myclass44;	
	}

	
	public MyClass44Builder id (Long id) 
	{
		myclass44.setId (id);
		return this;	
	}

	
	public MyClass44Builder initMyClass44 () 
	{
		myclass44 = new MyClass44();
		return this;	
	}


}
