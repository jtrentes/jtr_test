package big.domain.factories;

import big.domain.MyClass68;



public class MyClass68Builder
{

	
	
	private MyClass68 myclass68;
    

	
	public MyClass68 build () 
	{
		return myclass68;	
	}

	
	public MyClass68Builder id (Long id) 
	{
		myclass68.setId (id);
		return this;	
	}

	
	public MyClass68Builder initMyClass68 () 
	{
		myclass68 = new MyClass68();
		return this;	
	}


}
