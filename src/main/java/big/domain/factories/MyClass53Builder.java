package big.domain.factories;

import big.domain.MyClass53;



public class MyClass53Builder
{

	
	
	private MyClass53 myclass53;
    

	
	public MyClass53 build () 
	{
		return myclass53;	
	}

	
	public MyClass53Builder id (Long id) 
	{
		myclass53.setId (id);
		return this;	
	}

	
	public MyClass53Builder initMyClass53 () 
	{
		myclass53 = new MyClass53();
		return this;	
	}


}
