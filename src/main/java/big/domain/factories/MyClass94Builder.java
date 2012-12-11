package big.domain.factories;

import big.domain.MyClass94;



public class MyClass94Builder
{

	
	
	private MyClass94 myclass94;
    

	
	public MyClass94 build () 
	{
		return myclass94;	
	}

	
	public MyClass94Builder id (Long id) 
	{
		myclass94.setId (id);
		return this;	
	}

	
	public MyClass94Builder initMyClass94 () 
	{
		myclass94 = new MyClass94();
		return this;	
	}


}
