package big.domain.factories;

import big.domain.MyClass155;



public class MyClass155Builder
{

	
	
	private MyClass155 myclass155;
    

	
	public MyClass155 build () 
	{
		return myclass155;	
	}

	
	public MyClass155Builder id (Long id) 
	{
		myclass155.setId (id);
		return this;	
	}

	
	public MyClass155Builder initMyClass155 () 
	{
		myclass155 = new MyClass155();
		return this;	
	}


}
