package big.domain.factories;

import big.domain.MyClass137;



public class MyClass137Builder
{

	
	
	private MyClass137 myclass137;
    

	
	public MyClass137 build () 
	{
		return myclass137;	
	}

	
	public MyClass137Builder id (Long id) 
	{
		myclass137.setId (id);
		return this;	
	}

	
	public MyClass137Builder initMyClass137 () 
	{
		myclass137 = new MyClass137();
		return this;	
	}


}
