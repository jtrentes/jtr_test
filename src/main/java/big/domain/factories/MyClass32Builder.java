package big.domain.factories;

import big.domain.MyClass32;



public class MyClass32Builder
{

	
	
	private MyClass32 myclass32;
    

	
	public MyClass32 build () 
	{
		return myclass32;	
	}

	
	public MyClass32Builder id (Long id) 
	{
		myclass32.setId (id);
		return this;	
	}

	
	public MyClass32Builder initMyClass32 () 
	{
		myclass32 = new MyClass32();
		return this;	
	}


}
