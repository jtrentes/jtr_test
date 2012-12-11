package big.domain.factories;

import big.domain.MyClass50;



public class MyClass50Builder
{

	
	
	private MyClass50 myclass50;
    

	
	public MyClass50 build () 
	{
		return myclass50;	
	}

	
	public MyClass50Builder id (Long id) 
	{
		myclass50.setId (id);
		return this;	
	}

	
	public MyClass50Builder initMyClass50 () 
	{
		myclass50 = new MyClass50();
		return this;	
	}


}
