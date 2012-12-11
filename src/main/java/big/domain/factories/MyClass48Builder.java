package big.domain.factories;

import big.domain.MyClass48;



public class MyClass48Builder
{

	
	
	private MyClass48 myclass48;
    

	
	public MyClass48 build () 
	{
		return myclass48;	
	}

	
	public MyClass48Builder id (Long id) 
	{
		myclass48.setId (id);
		return this;	
	}

	
	public MyClass48Builder initMyClass48 () 
	{
		myclass48 = new MyClass48();
		return this;	
	}


}
