package big.domain.factories;

import big.domain.MyClass90;



public class MyClass90Builder
{

	
	
	private MyClass90 myclass90;
    

	
	public MyClass90 build () 
	{
		return myclass90;	
	}

	
	public MyClass90Builder id (Long id) 
	{
		myclass90.setId (id);
		return this;	
	}

	
	public MyClass90Builder initMyClass90 () 
	{
		myclass90 = new MyClass90();
		return this;	
	}


}
