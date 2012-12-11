package big.domain.factories;

import big.domain.MyClass37;



public class MyClass37Builder
{

	
	
	private MyClass37 myclass37;
    

	
	public MyClass37 build () 
	{
		return myclass37;	
	}

	
	public MyClass37Builder id (Long id) 
	{
		myclass37.setId (id);
		return this;	
	}

	
	public MyClass37Builder initMyClass37 () 
	{
		myclass37 = new MyClass37();
		return this;	
	}


}
