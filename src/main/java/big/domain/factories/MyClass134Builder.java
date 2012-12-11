package big.domain.factories;

import big.domain.MyClass134;



public class MyClass134Builder
{

	
	
	private MyClass134 myclass134;
    

	
	public MyClass134 build () 
	{
		return myclass134;	
	}

	
	public MyClass134Builder id (Long id) 
	{
		myclass134.setId (id);
		return this;	
	}

	
	public MyClass134Builder initMyClass134 () 
	{
		myclass134 = new MyClass134();
		return this;	
	}


}
