package big.domain.factories;

import big.domain.MyClass72;



public class MyClass72Builder
{

	
	
	private MyClass72 myclass72;
    

	
	public MyClass72 build () 
	{
		return myclass72;	
	}

	
	public MyClass72Builder id (Long id) 
	{
		myclass72.setId (id);
		return this;	
	}

	
	public MyClass72Builder initMyClass72 () 
	{
		myclass72 = new MyClass72();
		return this;	
	}


}
