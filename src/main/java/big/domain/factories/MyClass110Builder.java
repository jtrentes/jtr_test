package big.domain.factories;

import big.domain.MyClass110;



public class MyClass110Builder
{

	
	
	private MyClass110 myclass110;
    

	
	public MyClass110 build () 
	{
		return myclass110;	
	}

	
	public MyClass110Builder id (Long id) 
	{
		myclass110.setId (id);
		return this;	
	}

	
	public MyClass110Builder initMyClass110 () 
	{
		myclass110 = new MyClass110();
		return this;	
	}


}
