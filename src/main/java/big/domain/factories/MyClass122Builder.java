package big.domain.factories;

import big.domain.MyClass122;



public class MyClass122Builder
{

	
	
	private MyClass122 myclass122;
    

	
	public MyClass122 build () 
	{
		return myclass122;	
	}

	
	public MyClass122Builder id (Long id) 
	{
		myclass122.setId (id);
		return this;	
	}

	
	public MyClass122Builder initMyClass122 () 
	{
		myclass122 = new MyClass122();
		return this;	
	}


}
