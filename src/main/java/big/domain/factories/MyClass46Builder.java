package big.domain.factories;

import big.domain.MyClass46;



public class MyClass46Builder
{

	
	
	private MyClass46 myclass46;
    

	
	public MyClass46 build () 
	{
		return myclass46;	
	}

	
	public MyClass46Builder id (Long id) 
	{
		myclass46.setId (id);
		return this;	
	}

	
	public MyClass46Builder initMyClass46 () 
	{
		myclass46 = new MyClass46();
		return this;	
	}


}
