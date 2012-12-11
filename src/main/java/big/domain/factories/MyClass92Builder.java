package big.domain.factories;

import big.domain.MyClass92;



public class MyClass92Builder
{

	
	
	private MyClass92 myclass92;
    

	
	public MyClass92 build () 
	{
		return myclass92;	
	}

	
	public MyClass92Builder id (Long id) 
	{
		myclass92.setId (id);
		return this;	
	}

	
	public MyClass92Builder initMyClass92 () 
	{
		myclass92 = new MyClass92();
		return this;	
	}


}
