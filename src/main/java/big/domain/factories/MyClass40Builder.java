package big.domain.factories;

import big.domain.MyClass40;



public class MyClass40Builder
{

	
	
	private MyClass40 myclass40;
    

	
	public MyClass40 build () 
	{
		return myclass40;	
	}

	
	public MyClass40Builder id (Long id) 
	{
		myclass40.setId (id);
		return this;	
	}

	
	public MyClass40Builder initMyClass40 () 
	{
		myclass40 = new MyClass40();
		return this;	
	}


}
