package big.domain.factories;

import big.domain.MyClass59;



public class MyClass59Builder
{

	
	
	private MyClass59 myclass59;
    

	
	public MyClass59 build () 
	{
		return myclass59;	
	}

	
	public MyClass59Builder id (Long id) 
	{
		myclass59.setId (id);
		return this;	
	}

	
	public MyClass59Builder initMyClass59 () 
	{
		myclass59 = new MyClass59();
		return this;	
	}


}
