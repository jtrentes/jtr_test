package big.domain.factories;

import big.domain.MyClass42;



public class MyClass42Builder
{

	
	
	private MyClass42 myclass42;
    

	
	public MyClass42 build () 
	{
		return myclass42;	
	}

	
	public MyClass42Builder id (Long id) 
	{
		myclass42.setId (id);
		return this;	
	}

	
	public MyClass42Builder initMyClass42 () 
	{
		myclass42 = new MyClass42();
		return this;	
	}


}
