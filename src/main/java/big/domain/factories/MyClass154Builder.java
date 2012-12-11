package big.domain.factories;

import big.domain.MyClass154;



public class MyClass154Builder
{

	
	
	private MyClass154 myclass154;
    

	
	public MyClass154 build () 
	{
		return myclass154;	
	}

	
	public MyClass154Builder id (Long id) 
	{
		myclass154.setId (id);
		return this;	
	}

	
	public MyClass154Builder initMyClass154 () 
	{
		myclass154 = new MyClass154();
		return this;	
	}


}
