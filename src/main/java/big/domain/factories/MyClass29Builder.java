package big.domain.factories;

import big.domain.MyClass29;



public class MyClass29Builder
{

	
	
	private MyClass29 myclass29;
    

	
	public MyClass29 build () 
	{
		return myclass29;	
	}

	
	public MyClass29Builder id (Long id) 
	{
		myclass29.setId (id);
		return this;	
	}

	
	public MyClass29Builder initMyClass29 () 
	{
		myclass29 = new MyClass29();
		return this;	
	}


}
