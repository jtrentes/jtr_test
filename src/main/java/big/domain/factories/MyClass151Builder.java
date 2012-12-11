package big.domain.factories;

import big.domain.MyClass151;



public class MyClass151Builder
{

	
	
	private MyClass151 myclass151;
    

	
	public MyClass151 build () 
	{
		return myclass151;	
	}

	
	public MyClass151Builder id (Long id) 
	{
		myclass151.setId (id);
		return this;	
	}

	
	public MyClass151Builder initMyClass151 () 
	{
		myclass151 = new MyClass151();
		return this;	
	}


}
