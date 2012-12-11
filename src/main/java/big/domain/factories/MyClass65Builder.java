package big.domain.factories;

import big.domain.MyClass65;



public class MyClass65Builder
{

	
	
	private MyClass65 myclass65;
    

	
	public MyClass65 build () 
	{
		return myclass65;	
	}

	
	public MyClass65Builder id (Long id) 
	{
		myclass65.setId (id);
		return this;	
	}

	
	public MyClass65Builder initMyClass65 () 
	{
		myclass65 = new MyClass65();
		return this;	
	}


}
