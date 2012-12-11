package big.domain.factories;

import big.domain.MyClass15;



public class MyClass15Builder
{

	
	
	private MyClass15 myclass15;
    

	
	public MyClass15 build () 
	{
		return myclass15;	
	}

	
	public MyClass15Builder id (Long id) 
	{
		myclass15.setId (id);
		return this;	
	}

	
	public MyClass15Builder initMyClass15 () 
	{
		myclass15 = new MyClass15();
		return this;	
	}


}
