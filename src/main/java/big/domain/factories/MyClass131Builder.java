package big.domain.factories;

import big.domain.MyClass131;



public class MyClass131Builder
{

	
	
	private MyClass131 myclass131;
    

	
	public MyClass131 build () 
	{
		return myclass131;	
	}

	
	public MyClass131Builder id (Long id) 
	{
		myclass131.setId (id);
		return this;	
	}

	
	public MyClass131Builder initMyClass131 () 
	{
		myclass131 = new MyClass131();
		return this;	
	}


}
