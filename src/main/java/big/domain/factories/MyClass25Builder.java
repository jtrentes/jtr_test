package big.domain.factories;

import big.domain.MyClass25;



public class MyClass25Builder
{

	
	
	private MyClass25 myclass25;
    

	
	public MyClass25 build () 
	{
		return myclass25;	
	}

	
	public MyClass25Builder id (Long id) 
	{
		myclass25.setId (id);
		return this;	
	}

	
	public MyClass25Builder initMyClass25 () 
	{
		myclass25 = new MyClass25();
		return this;	
	}


}
