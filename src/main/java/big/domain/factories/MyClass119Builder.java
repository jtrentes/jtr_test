package big.domain.factories;

import big.domain.MyClass119;



public class MyClass119Builder
{

	
	
	private MyClass119 myclass119;
    

	
	public MyClass119 build () 
	{
		return myclass119;	
	}

	
	public MyClass119Builder id (Long id) 
	{
		myclass119.setId (id);
		return this;	
	}

	
	public MyClass119Builder initMyClass119 () 
	{
		myclass119 = new MyClass119();
		return this;	
	}


}
