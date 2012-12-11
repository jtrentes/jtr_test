package big.domain.factories;

import big.domain.MyClass107;



public class MyClass107Builder
{

	
	
	private MyClass107 myclass107;
    

	
	public MyClass107 build () 
	{
		return myclass107;	
	}

	
	public MyClass107Builder id (Long id) 
	{
		myclass107.setId (id);
		return this;	
	}

	
	public MyClass107Builder initMyClass107 () 
	{
		myclass107 = new MyClass107();
		return this;	
	}


}
