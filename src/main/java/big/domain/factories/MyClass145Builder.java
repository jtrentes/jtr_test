package big.domain.factories;

import big.domain.MyClass145;



public class MyClass145Builder
{

	
	
	private MyClass145 myclass145;
    

	
	public MyClass145 build () 
	{
		return myclass145;	
	}

	
	public MyClass145Builder id (Long id) 
	{
		myclass145.setId (id);
		return this;	
	}

	
	public MyClass145Builder initMyClass145 () 
	{
		myclass145 = new MyClass145();
		return this;	
	}


}
