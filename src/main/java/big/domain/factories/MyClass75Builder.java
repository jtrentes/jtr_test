package big.domain.factories;

import big.domain.MyClass75;



public class MyClass75Builder
{

	
	
	private MyClass75 myclass75;
    

	
	public MyClass75 build () 
	{
		return myclass75;	
	}

	
	public MyClass75Builder id (Long id) 
	{
		myclass75.setId (id);
		return this;	
	}

	
	public MyClass75Builder initMyClass75 () 
	{
		myclass75 = new MyClass75();
		return this;	
	}


}
