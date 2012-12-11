package big.domain.factories;

import big.domain.MyClass93;



public class MyClass93Builder
{

	
	
	private MyClass93 myclass93;
    

	
	public MyClass93 build () 
	{
		return myclass93;	
	}

	
	public MyClass93Builder id (Long id) 
	{
		myclass93.setId (id);
		return this;	
	}

	
	public MyClass93Builder initMyClass93 () 
	{
		myclass93 = new MyClass93();
		return this;	
	}


}
