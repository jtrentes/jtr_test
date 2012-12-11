package big.domain.factories;

import big.domain.MyClass69;



public class MyClass69Builder
{

	
	
	private MyClass69 myclass69;
    

	
	public MyClass69 build () 
	{
		return myclass69;	
	}

	
	public MyClass69Builder id (Long id) 
	{
		myclass69.setId (id);
		return this;	
	}

	
	public MyClass69Builder initMyClass69 () 
	{
		myclass69 = new MyClass69();
		return this;	
	}


}
