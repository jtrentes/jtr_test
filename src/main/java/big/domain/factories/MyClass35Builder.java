package big.domain.factories;

import big.domain.MyClass35;



public class MyClass35Builder
{

	
	
	private MyClass35 myclass35;
    

	
	public MyClass35 build () 
	{
		return myclass35;	
	}

	
	public MyClass35Builder id (Long id) 
	{
		myclass35.setId (id);
		return this;	
	}

	
	public MyClass35Builder initMyClass35 () 
	{
		myclass35 = new MyClass35();
		return this;	
	}


}
