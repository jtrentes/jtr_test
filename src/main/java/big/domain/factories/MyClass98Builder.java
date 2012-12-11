package big.domain.factories;

import big.domain.MyClass98;



public class MyClass98Builder
{

	
	
	private MyClass98 myclass98;
    

	
	public MyClass98 build () 
	{
		return myclass98;	
	}

	
	public MyClass98Builder id (Long id) 
	{
		myclass98.setId (id);
		return this;	
	}

	
	public MyClass98Builder initMyClass98 () 
	{
		myclass98 = new MyClass98();
		return this;	
	}


}
