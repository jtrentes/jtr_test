package big.domain.factories;

import big.domain.MyClass109;



public class MyClass109Builder
{

	
	
	private MyClass109 myclass109;
    

	
	public MyClass109 build () 
	{
		return myclass109;	
	}

	
	public MyClass109Builder id (Long id) 
	{
		myclass109.setId (id);
		return this;	
	}

	
	public MyClass109Builder initMyClass109 () 
	{
		myclass109 = new MyClass109();
		return this;	
	}


}
