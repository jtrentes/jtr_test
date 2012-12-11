package big.domain.factories;

import big.domain.MyClass162;



public class MyClass162Builder
{

	
	
	private MyClass162 myclass162;
    

	
	public MyClass162 build () 
	{
		return myclass162;	
	}

	
	public MyClass162Builder id (Long id) 
	{
		myclass162.setId (id);
		return this;	
	}

	
	public MyClass162Builder initMyClass162 () 
	{
		myclass162 = new MyClass162();
		return this;	
	}


}
