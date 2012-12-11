package big.domain.factories;

import big.domain.MyClass10;



public class MyClass10Builder
{

	
	
	private MyClass10 myclass10;
    

	
	public MyClass10 build () 
	{
		return myclass10;	
	}

	
	public MyClass10Builder id (Long id) 
	{
		myclass10.setId (id);
		return this;	
	}

	
	public MyClass10Builder initMyClass10 () 
	{
		myclass10 = new MyClass10();
		return this;	
	}


}
