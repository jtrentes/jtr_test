package big.domain.factories;

import big.domain.MyClass41;



public class MyClass41Builder
{

	
	
	private MyClass41 myclass41;
    

	
	public MyClass41 build () 
	{
		return myclass41;	
	}

	
	public MyClass41Builder id (Long id) 
	{
		myclass41.setId (id);
		return this;	
	}

	
	public MyClass41Builder initMyClass41 () 
	{
		myclass41 = new MyClass41();
		return this;	
	}


}
