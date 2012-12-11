package big.domain.factories;

import big.domain.MyClass39;



public class MyClass39Builder
{

	
	
	private MyClass39 myclass39;
    

	
	public MyClass39 build () 
	{
		return myclass39;	
	}

	
	public MyClass39Builder id (Long id) 
	{
		myclass39.setId (id);
		return this;	
	}

	
	public MyClass39Builder initMyClass39 () 
	{
		myclass39 = new MyClass39();
		return this;	
	}


}
