package big.domain.factories;

import big.domain.MyClass116;



public class MyClass116Builder
{

	
	
	private MyClass116 myclass116;
    

	
	public MyClass116 build () 
	{
		return myclass116;	
	}

	
	public MyClass116Builder id (Long id) 
	{
		myclass116.setId (id);
		return this;	
	}

	
	public MyClass116Builder initMyClass116 () 
	{
		myclass116 = new MyClass116();
		return this;	
	}


}
