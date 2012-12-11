package big.domain.factories;

import big.domain.MyClass127;



public class MyClass127Builder
{

	
	
	private MyClass127 myclass127;
    

	
	public MyClass127 build () 
	{
		return myclass127;	
	}

	
	public MyClass127Builder id (Long id) 
	{
		myclass127.setId (id);
		return this;	
	}

	
	public MyClass127Builder initMyClass127 () 
	{
		myclass127 = new MyClass127();
		return this;	
	}


}
