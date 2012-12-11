package big.domain.factories;

import big.domain.MyClass111;



public class MyClass111Builder
{

	
	
	private MyClass111 myclass111;
    

	
	public MyClass111 build () 
	{
		return myclass111;	
	}

	
	public MyClass111Builder id (Long id) 
	{
		myclass111.setId (id);
		return this;	
	}

	
	public MyClass111Builder initMyClass111 () 
	{
		myclass111 = new MyClass111();
		return this;	
	}


}
