package big.domain.factories;

import big.domain.MyClass88;



public class MyClass88Builder
{

	
	
	private MyClass88 myclass88;
    

	
	public MyClass88 build () 
	{
		return myclass88;	
	}

	
	public MyClass88Builder id (Long id) 
	{
		myclass88.setId (id);
		return this;	
	}

	
	public MyClass88Builder initMyClass88 () 
	{
		myclass88 = new MyClass88();
		return this;	
	}


}
