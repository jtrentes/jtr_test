package big.domain.factories;

import big.domain.MyClass3;



public class MyClass3Builder
{

	
	
	private MyClass3 myclass3;
    

	
	public MyClass3 build () 
	{
		return myclass3;	
	}

	
	public MyClass3Builder id (Long id) 
	{
		myclass3.setId (id);
		return this;	
	}

	
	public MyClass3Builder initMyClass3 () 
	{
		myclass3 = new MyClass3();
		return this;	
	}


}
