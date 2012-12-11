package big.domain.factories;

import big.domain.MyClass79;



public class MyClass79Builder
{

	
	
	private MyClass79 myclass79;
    

	
	public MyClass79 build () 
	{
		return myclass79;	
	}

	
	public MyClass79Builder id (Long id) 
	{
		myclass79.setId (id);
		return this;	
	}

	
	public MyClass79Builder initMyClass79 () 
	{
		myclass79 = new MyClass79();
		return this;	
	}


}
