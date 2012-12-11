package big.domain.factories;

import big.domain.MyClass19;



public class MyClass19Builder
{

	
	
	private MyClass19 myclass19;
    

	
	public MyClass19 build () 
	{
		return myclass19;	
	}

	
	public MyClass19Builder id (Long id) 
	{
		myclass19.setId (id);
		return this;	
	}

	
	public MyClass19Builder initMyClass19 () 
	{
		myclass19 = new MyClass19();
		return this;	
	}


}
