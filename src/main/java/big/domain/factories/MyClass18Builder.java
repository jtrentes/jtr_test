package big.domain.factories;

import big.domain.MyClass18;



public class MyClass18Builder
{

	
	
	private MyClass18 myclass18;
    

	
	public MyClass18 build () 
	{
		return myclass18;	
	}

	
	public MyClass18Builder id (Long id) 
	{
		myclass18.setId (id);
		return this;	
	}

	
	public MyClass18Builder initMyClass18 () 
	{
		myclass18 = new MyClass18();
		return this;	
	}


}
