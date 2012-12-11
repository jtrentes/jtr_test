package big.domain.factories;

import big.domain.MyClass74;



public class MyClass74Builder
{

	
	
	private MyClass74 myclass74;
    

	
	public MyClass74 build () 
	{
		return myclass74;	
	}

	
	public MyClass74Builder id (Long id) 
	{
		myclass74.setId (id);
		return this;	
	}

	
	public MyClass74Builder initMyClass74 () 
	{
		myclass74 = new MyClass74();
		return this;	
	}


}
