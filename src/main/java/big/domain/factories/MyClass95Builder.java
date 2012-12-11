package big.domain.factories;

import big.domain.MyClass95;



public class MyClass95Builder
{

	
	
	private MyClass95 myclass95;
    

	
	public MyClass95 build () 
	{
		return myclass95;	
	}

	
	public MyClass95Builder id (Long id) 
	{
		myclass95.setId (id);
		return this;	
	}

	
	public MyClass95Builder initMyClass95 () 
	{
		myclass95 = new MyClass95();
		return this;	
	}


}
