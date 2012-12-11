package big.domain.factories;

import big.domain.MyClass71;



public class MyClass71Builder
{

	
	
	private MyClass71 myclass71;
    

	
	public MyClass71 build () 
	{
		return myclass71;	
	}

	
	public MyClass71Builder id (Long id) 
	{
		myclass71.setId (id);
		return this;	
	}

	
	public MyClass71Builder initMyClass71 () 
	{
		myclass71 = new MyClass71();
		return this;	
	}


}
