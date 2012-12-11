package big.domain.factories;

import big.domain.MyClass51;



public class MyClass51Builder
{

	
	
	private MyClass51 myclass51;
    

	
	public MyClass51 build () 
	{
		return myclass51;	
	}

	
	public MyClass51Builder id (Long id) 
	{
		myclass51.setId (id);
		return this;	
	}

	
	public MyClass51Builder initMyClass51 () 
	{
		myclass51 = new MyClass51();
		return this;	
	}


}
