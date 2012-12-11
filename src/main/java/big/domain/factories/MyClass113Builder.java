package big.domain.factories;

import big.domain.MyClass113;



public class MyClass113Builder
{

	
	
	private MyClass113 myclass113;
    

	
	public MyClass113 build () 
	{
		return myclass113;	
	}

	
	public MyClass113Builder id (Long id) 
	{
		myclass113.setId (id);
		return this;	
	}

	
	public MyClass113Builder initMyClass113 () 
	{
		myclass113 = new MyClass113();
		return this;	
	}


}
