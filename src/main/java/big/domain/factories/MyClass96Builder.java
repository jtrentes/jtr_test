package big.domain.factories;

import big.domain.MyClass96;



public class MyClass96Builder
{

	
	
	private MyClass96 myclass96;
    

	
	public MyClass96 build () 
	{
		return myclass96;	
	}

	
	public MyClass96Builder id (Long id) 
	{
		myclass96.setId (id);
		return this;	
	}

	
	public MyClass96Builder initMyClass96 () 
	{
		myclass96 = new MyClass96();
		return this;	
	}


}
