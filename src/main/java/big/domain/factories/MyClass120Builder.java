package big.domain.factories;

import big.domain.MyClass120;



public class MyClass120Builder
{

	
	
	private MyClass120 myclass120;
    

	
	public MyClass120 build () 
	{
		return myclass120;	
	}

	
	public MyClass120Builder id (Long id) 
	{
		myclass120.setId (id);
		return this;	
	}

	
	public MyClass120Builder initMyClass120 () 
	{
		myclass120 = new MyClass120();
		return this;	
	}


}
