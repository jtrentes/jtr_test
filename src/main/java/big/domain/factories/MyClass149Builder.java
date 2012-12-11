package big.domain.factories;

import big.domain.MyClass149;



public class MyClass149Builder
{

	
	
	private MyClass149 myclass149;
    

	
	public MyClass149 build () 
	{
		return myclass149;	
	}

	
	public MyClass149Builder id (Long id) 
	{
		myclass149.setId (id);
		return this;	
	}

	
	public MyClass149Builder initMyClass149 () 
	{
		myclass149 = new MyClass149();
		return this;	
	}


}
