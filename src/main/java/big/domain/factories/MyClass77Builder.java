package big.domain.factories;

import big.domain.MyClass77;



public class MyClass77Builder
{

	
	
	private MyClass77 myclass77;
    

	
	public MyClass77 build () 
	{
		return myclass77;	
	}

	
	public MyClass77Builder id (Long id) 
	{
		myclass77.setId (id);
		return this;	
	}

	
	public MyClass77Builder initMyClass77 () 
	{
		myclass77 = new MyClass77();
		return this;	
	}


}
