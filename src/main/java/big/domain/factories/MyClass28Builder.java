package big.domain.factories;

import big.domain.MyClass28;



public class MyClass28Builder
{

	
	
	private MyClass28 myclass28;
    

	
	public MyClass28 build () 
	{
		return myclass28;	
	}

	
	public MyClass28Builder id (Long id) 
	{
		myclass28.setId (id);
		return this;	
	}

	
	public MyClass28Builder initMyClass28 () 
	{
		myclass28 = new MyClass28();
		return this;	
	}


}
