package big.domain.factories;

import big.domain.MyClass30;



public class MyClass30Builder
{

	
	
	private MyClass30 myclass30;
    

	
	public MyClass30 build () 
	{
		return myclass30;	
	}

	
	public MyClass30Builder id (Long id) 
	{
		myclass30.setId (id);
		return this;	
	}

	
	public MyClass30Builder initMyClass30 () 
	{
		myclass30 = new MyClass30();
		return this;	
	}


}
