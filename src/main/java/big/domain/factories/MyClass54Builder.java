package big.domain.factories;

import big.domain.MyClass54;



public class MyClass54Builder
{

	
	
	private MyClass54 myclass54;
    

	
	public MyClass54 build () 
	{
		return myclass54;	
	}

	
	public MyClass54Builder id (Long id) 
	{
		myclass54.setId (id);
		return this;	
	}

	
	public MyClass54Builder initMyClass54 () 
	{
		myclass54 = new MyClass54();
		return this;	
	}


}
