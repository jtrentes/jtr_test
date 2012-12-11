package big.domain.factories;

import big.domain.MyClass132;



public class MyClass132Builder
{

	
	
	private MyClass132 myclass132;
    

	
	public MyClass132 build () 
	{
		return myclass132;	
	}

	
	public MyClass132Builder id (Long id) 
	{
		myclass132.setId (id);
		return this;	
	}

	
	public MyClass132Builder initMyClass132 () 
	{
		myclass132 = new MyClass132();
		return this;	
	}


}
