package big.domain.factories;

import big.domain.MyClass73;



public class MyClass73Builder
{

	
	
	private MyClass73 myclass73;
    

	
	public MyClass73 build () 
	{
		return myclass73;	
	}

	
	public MyClass73Builder id (Long id) 
	{
		myclass73.setId (id);
		return this;	
	}

	
	public MyClass73Builder initMyClass73 () 
	{
		myclass73 = new MyClass73();
		return this;	
	}


}
