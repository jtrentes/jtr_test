package big.domain.factories;

import big.domain.MyClass121;



public class MyClass121Builder
{

	
	
	private MyClass121 myclass121;
    

	
	public MyClass121 build () 
	{
		return myclass121;	
	}

	
	public MyClass121Builder id (Long id) 
	{
		myclass121.setId (id);
		return this;	
	}

	
	public MyClass121Builder initMyClass121 () 
	{
		myclass121 = new MyClass121();
		return this;	
	}


}
