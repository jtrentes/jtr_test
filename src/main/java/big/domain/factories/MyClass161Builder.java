package big.domain.factories;

import big.domain.MyClass161;



public class MyClass161Builder
{

	
	
	private MyClass161 myclass161;
    

	
	public MyClass161 build () 
	{
		return myclass161;	
	}

	
	public MyClass161Builder id (Long id) 
	{
		myclass161.setId (id);
		return this;	
	}

	
	public MyClass161Builder initMyClass161 () 
	{
		myclass161 = new MyClass161();
		return this;	
	}


}
