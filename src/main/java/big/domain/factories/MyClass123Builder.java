package big.domain.factories;

import big.domain.MyClass123;



public class MyClass123Builder
{

	
	
	private MyClass123 myclass123;
    

	
	public MyClass123 build () 
	{
		return myclass123;	
	}

	
	public MyClass123Builder id (Long id) 
	{
		myclass123.setId (id);
		return this;	
	}

	
	public MyClass123Builder initMyClass123 () 
	{
		myclass123 = new MyClass123();
		return this;	
	}


}
