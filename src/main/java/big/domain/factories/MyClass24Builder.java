package big.domain.factories;

import big.domain.MyClass24;



public class MyClass24Builder
{

	
	
	private MyClass24 myclass24;
    

	
	public MyClass24 build () 
	{
		return myclass24;	
	}

	
	public MyClass24Builder id (Long id) 
	{
		myclass24.setId (id);
		return this;	
	}

	
	public MyClass24Builder initMyClass24 () 
	{
		myclass24 = new MyClass24();
		return this;	
	}


}
