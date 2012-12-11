package big.domain.factories;

import big.domain.MyClass101;



public class MyClass101Builder
{

	
	
	private MyClass101 myclass101;
    

	
	public MyClass101 build () 
	{
		return myclass101;	
	}

	
	public MyClass101Builder id (Long id) 
	{
		myclass101.setId (id);
		return this;	
	}

	
	public MyClass101Builder initMyClass101 () 
	{
		myclass101 = new MyClass101();
		return this;	
	}


}
