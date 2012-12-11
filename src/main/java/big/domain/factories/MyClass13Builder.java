package big.domain.factories;

import big.domain.MyClass13;



public class MyClass13Builder
{

	
	
	private MyClass13 myclass13;
    

	
	public MyClass13 build () 
	{
		return myclass13;	
	}

	
	public MyClass13Builder id (Long id) 
	{
		myclass13.setId (id);
		return this;	
	}

	
	public MyClass13Builder initMyClass13 () 
	{
		myclass13 = new MyClass13();
		return this;	
	}


}
