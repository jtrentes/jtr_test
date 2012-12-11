package big.domain.factories;

import big.domain.MyClass11;



public class MyClass11Builder
{

	
	
	private MyClass11 myclass11;
    

	
	public MyClass11 build () 
	{
		return myclass11;	
	}

	
	public MyClass11Builder id (Long id) 
	{
		myclass11.setId (id);
		return this;	
	}

	
	public MyClass11Builder initMyClass11 () 
	{
		myclass11 = new MyClass11();
		return this;	
	}


}
