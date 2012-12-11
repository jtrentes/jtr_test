package big.domain.factories;

import big.domain.MyClass62;



public class MyClass62Builder
{

	
	
	private MyClass62 myclass62;
    

	
	public MyClass62 build () 
	{
		return myclass62;	
	}

	
	public MyClass62Builder id (Long id) 
	{
		myclass62.setId (id);
		return this;	
	}

	
	public MyClass62Builder initMyClass62 () 
	{
		myclass62 = new MyClass62();
		return this;	
	}


}
