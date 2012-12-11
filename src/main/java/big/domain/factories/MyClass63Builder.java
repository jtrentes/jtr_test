package big.domain.factories;

import big.domain.MyClass63;



public class MyClass63Builder
{

	
	
	private MyClass63 myclass63;
    

	
	public MyClass63 build () 
	{
		return myclass63;	
	}

	
	public MyClass63Builder id (Long id) 
	{
		myclass63.setId (id);
		return this;	
	}

	
	public MyClass63Builder initMyClass63 () 
	{
		myclass63 = new MyClass63();
		return this;	
	}


}
