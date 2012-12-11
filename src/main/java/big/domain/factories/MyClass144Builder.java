package big.domain.factories;

import big.domain.MyClass144;



public class MyClass144Builder
{

	
	
	private MyClass144 myclass144;
    

	
	public MyClass144 build () 
	{
		return myclass144;	
	}

	
	public MyClass144Builder id (Long id) 
	{
		myclass144.setId (id);
		return this;	
	}

	
	public MyClass144Builder initMyClass144 () 
	{
		myclass144 = new MyClass144();
		return this;	
	}


}
