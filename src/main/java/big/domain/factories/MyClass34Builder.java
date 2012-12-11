package big.domain.factories;

import big.domain.MyClass34;



public class MyClass34Builder
{

	
	
	private MyClass34 myclass34;
    

	
	public MyClass34 build () 
	{
		return myclass34;	
	}

	
	public MyClass34Builder id (Long id) 
	{
		myclass34.setId (id);
		return this;	
	}

	
	public MyClass34Builder initMyClass34 () 
	{
		myclass34 = new MyClass34();
		return this;	
	}


}
