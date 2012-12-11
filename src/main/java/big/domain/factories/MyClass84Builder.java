package big.domain.factories;

import big.domain.MyClass84;



public class MyClass84Builder
{

	
	
	private MyClass84 myclass84;
    

	
	public MyClass84 build () 
	{
		return myclass84;	
	}

	
	public MyClass84Builder id (Long id) 
	{
		myclass84.setId (id);
		return this;	
	}

	
	public MyClass84Builder initMyClass84 () 
	{
		myclass84 = new MyClass84();
		return this;	
	}


}
