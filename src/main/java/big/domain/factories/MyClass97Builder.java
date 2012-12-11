package big.domain.factories;

import big.domain.MyClass97;



public class MyClass97Builder
{

	
	
	private MyClass97 myclass97;
    

	
	public MyClass97 build () 
	{
		return myclass97;	
	}

	
	public MyClass97Builder id (Long id) 
	{
		myclass97.setId (id);
		return this;	
	}

	
	public MyClass97Builder initMyClass97 () 
	{
		myclass97 = new MyClass97();
		return this;	
	}


}
