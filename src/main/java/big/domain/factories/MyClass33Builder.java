package big.domain.factories;

import big.domain.MyClass33;



public class MyClass33Builder
{

	
	
	private MyClass33 myclass33;
    

	
	public MyClass33 build () 
	{
		return myclass33;	
	}

	
	public MyClass33Builder id (Long id) 
	{
		myclass33.setId (id);
		return this;	
	}

	
	public MyClass33Builder initMyClass33 () 
	{
		myclass33 = new MyClass33();
		return this;	
	}


}
