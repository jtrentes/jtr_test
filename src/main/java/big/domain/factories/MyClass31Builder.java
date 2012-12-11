package big.domain.factories;

import big.domain.MyClass31;



public class MyClass31Builder
{

	
	
	private MyClass31 myclass31;
    

	
	public MyClass31 build () 
	{
		return myclass31;	
	}

	
	public MyClass31Builder id (Long id) 
	{
		myclass31.setId (id);
		return this;	
	}

	
	public MyClass31Builder initMyClass31 () 
	{
		myclass31 = new MyClass31();
		return this;	
	}


}
