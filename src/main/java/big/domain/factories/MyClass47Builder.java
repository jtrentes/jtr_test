package big.domain.factories;

import big.domain.MyClass47;



public class MyClass47Builder
{

	
	
	private MyClass47 myclass47;
    

	
	public MyClass47 build () 
	{
		return myclass47;	
	}

	
	public MyClass47Builder id (Long id) 
	{
		myclass47.setId (id);
		return this;	
	}

	
	public MyClass47Builder initMyClass47 () 
	{
		myclass47 = new MyClass47();
		return this;	
	}


}
