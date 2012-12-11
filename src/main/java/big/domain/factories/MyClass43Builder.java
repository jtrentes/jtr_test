package big.domain.factories;

import big.domain.MyClass43;



public class MyClass43Builder
{

	
	
	private MyClass43 myclass43;
    

	
	public MyClass43 build () 
	{
		return myclass43;	
	}

	
	public MyClass43Builder id (Long id) 
	{
		myclass43.setId (id);
		return this;	
	}

	
	public MyClass43Builder initMyClass43 () 
	{
		myclass43 = new MyClass43();
		return this;	
	}


}
