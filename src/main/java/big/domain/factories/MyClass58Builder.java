package big.domain.factories;

import big.domain.MyClass58;



public class MyClass58Builder
{

	
	
	private MyClass58 myclass58;
    

	
	public MyClass58 build () 
	{
		return myclass58;	
	}

	
	public MyClass58Builder id (Long id) 
	{
		myclass58.setId (id);
		return this;	
	}

	
	public MyClass58Builder initMyClass58 () 
	{
		myclass58 = new MyClass58();
		return this;	
	}


}
