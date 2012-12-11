package big.domain.factories;

import big.domain.MyClass66;



public class MyClass66Builder
{

	
	
	private MyClass66 myclass66;
    

	
	public MyClass66 build () 
	{
		return myclass66;	
	}

	
	public MyClass66Builder id (Long id) 
	{
		myclass66.setId (id);
		return this;	
	}

	
	public MyClass66Builder initMyClass66 () 
	{
		myclass66 = new MyClass66();
		return this;	
	}


}
