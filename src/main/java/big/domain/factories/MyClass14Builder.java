package big.domain.factories;

import big.domain.MyClass14;



public class MyClass14Builder
{

	
	
	private MyClass14 myclass14;
    

	
	public MyClass14 build () 
	{
		return myclass14;	
	}

	
	public MyClass14Builder id (Long id) 
	{
		myclass14.setId (id);
		return this;	
	}

	
	public MyClass14Builder initMyClass14 () 
	{
		myclass14 = new MyClass14();
		return this;	
	}


}
