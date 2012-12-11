package big.domain.factories;

import big.domain.MyClass150;



public class MyClass150Builder
{

	
	
	private MyClass150 myclass150;
    

	
	public MyClass150 build () 
	{
		return myclass150;	
	}

	
	public MyClass150Builder id (Long id) 
	{
		myclass150.setId (id);
		return this;	
	}

	
	public MyClass150Builder initMyClass150 () 
	{
		myclass150 = new MyClass150();
		return this;	
	}


}
