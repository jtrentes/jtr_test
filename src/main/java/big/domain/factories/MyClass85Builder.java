package big.domain.factories;

import big.domain.MyClass85;



public class MyClass85Builder
{

	
	
	private MyClass85 myclass85;
    

	
	public MyClass85 build () 
	{
		return myclass85;	
	}

	
	public MyClass85Builder id (Long id) 
	{
		myclass85.setId (id);
		return this;	
	}

	
	public MyClass85Builder initMyClass85 () 
	{
		myclass85 = new MyClass85();
		return this;	
	}


}
