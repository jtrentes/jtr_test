package big.domain.factories;

import big.domain.MyClass156;



public class MyClass156Builder
{

	
	
	private MyClass156 myclass156;
    

	
	public MyClass156 build () 
	{
		return myclass156;	
	}

	
	public MyClass156Builder id (Long id) 
	{
		myclass156.setId (id);
		return this;	
	}

	
	public MyClass156Builder initMyClass156 () 
	{
		myclass156 = new MyClass156();
		return this;	
	}


}
