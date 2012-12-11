package big.domain.factories;

import big.domain.MyClass12;



public class MyClass12Builder
{

	
	
	private MyClass12 myclass12;
    

	
	public MyClass12 build () 
	{
		return myclass12;	
	}

	
	public MyClass12Builder id (Long id) 
	{
		myclass12.setId (id);
		return this;	
	}

	
	public MyClass12Builder initMyClass12 () 
	{
		myclass12 = new MyClass12();
		return this;	
	}


}
