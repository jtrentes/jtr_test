package big.domain.factories;

import big.domain.MyClass148;



public class MyClass148Builder
{

	
	
	private MyClass148 myclass148;
    

	
	public MyClass148 build () 
	{
		return myclass148;	
	}

	
	public MyClass148Builder id (Long id) 
	{
		myclass148.setId (id);
		return this;	
	}

	
	public MyClass148Builder initMyClass148 () 
	{
		myclass148 = new MyClass148();
		return this;	
	}


}
