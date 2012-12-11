package big.domain.factories;

import big.domain.MyClass81;



public class MyClass81Builder
{

	
	
	private MyClass81 myclass81;
    

	
	public MyClass81 build () 
	{
		return myclass81;	
	}

	
	public MyClass81Builder id (Long id) 
	{
		myclass81.setId (id);
		return this;	
	}

	
	public MyClass81Builder initMyClass81 () 
	{
		myclass81 = new MyClass81();
		return this;	
	}


}
