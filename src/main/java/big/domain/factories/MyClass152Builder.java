package big.domain.factories;

import big.domain.MyClass152;



public class MyClass152Builder
{

	
	
	private MyClass152 myclass152;
    

	
	public MyClass152 build () 
	{
		return myclass152;	
	}

	
	public MyClass152Builder id (Long id) 
	{
		myclass152.setId (id);
		return this;	
	}

	
	public MyClass152Builder initMyClass152 () 
	{
		myclass152 = new MyClass152();
		return this;	
	}


}
