package big.domain.factories;

import big.domain.MyClass115;



public class MyClass115Builder
{

	
	
	private MyClass115 myclass115;
    

	
	public MyClass115 build () 
	{
		return myclass115;	
	}

	
	public MyClass115Builder id (Long id) 
	{
		myclass115.setId (id);
		return this;	
	}

	
	public MyClass115Builder initMyClass115 () 
	{
		myclass115 = new MyClass115();
		return this;	
	}


}
