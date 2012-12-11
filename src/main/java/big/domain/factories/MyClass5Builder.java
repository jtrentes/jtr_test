package big.domain.factories;

import big.domain.MyClass5;



public class MyClass5Builder
{

	
	
	private MyClass5 myclass5;
    

	
	public MyClass5 build () 
	{
		return myclass5;	
	}

	
	public MyClass5Builder id (Long id) 
	{
		myclass5.setId (id);
		return this;	
	}

	
	public MyClass5Builder initMyClass5 () 
	{
		myclass5 = new MyClass5();
		return this;	
	}


}
