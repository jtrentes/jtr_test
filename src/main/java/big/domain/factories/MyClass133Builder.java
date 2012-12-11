package big.domain.factories;

import big.domain.MyClass133;



public class MyClass133Builder
{

	
	
	private MyClass133 myclass133;
    

	
	public MyClass133 build () 
	{
		return myclass133;	
	}

	
	public MyClass133Builder id (Long id) 
	{
		myclass133.setId (id);
		return this;	
	}

	
	public MyClass133Builder initMyClass133 () 
	{
		myclass133 = new MyClass133();
		return this;	
	}


}
