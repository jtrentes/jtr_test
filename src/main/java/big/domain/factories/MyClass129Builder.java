package big.domain.factories;

import big.domain.MyClass129;



public class MyClass129Builder
{

	
	
	private MyClass129 myclass129;
    

	
	public MyClass129 build () 
	{
		return myclass129;	
	}

	
	public MyClass129Builder id (Long id) 
	{
		myclass129.setId (id);
		return this;	
	}

	
	public MyClass129Builder initMyClass129 () 
	{
		myclass129 = new MyClass129();
		return this;	
	}


}
