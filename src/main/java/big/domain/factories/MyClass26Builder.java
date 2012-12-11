package big.domain.factories;

import big.domain.MyClass26;



public class MyClass26Builder
{

	
	
	private MyClass26 myclass26;
    

	
	public MyClass26 build () 
	{
		return myclass26;	
	}

	
	public MyClass26Builder id (Long id) 
	{
		myclass26.setId (id);
		return this;	
	}

	
	public MyClass26Builder initMyClass26 () 
	{
		myclass26 = new MyClass26();
		return this;	
	}


}
