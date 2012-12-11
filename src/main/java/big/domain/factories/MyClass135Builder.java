package big.domain.factories;

import big.domain.MyClass135;



public class MyClass135Builder
{

	
	
	private MyClass135 myclass135;
    

	
	public MyClass135 build () 
	{
		return myclass135;	
	}

	
	public MyClass135Builder id (Long id) 
	{
		myclass135.setId (id);
		return this;	
	}

	
	public MyClass135Builder initMyClass135 () 
	{
		myclass135 = new MyClass135();
		return this;	
	}


}
