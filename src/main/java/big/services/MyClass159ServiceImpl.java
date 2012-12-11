package big.services;

import big.repositories.criteria.MyClass159Criteria;
import big.repositories.MyClass159Repository;
import big.domain.MyClass159;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass159Service")
@Transactional(readOnly = true)
public class MyClass159ServiceImpl implements MyClass159Service
{

	
	@Autowired
	private MyClass159Repository myClass159Repository;
    

	
	public List<MyClass159> findAll () 
	{
		return this.myClass159Repository.findAll();	
	}

	
	public List<MyClass159> findByCriteria (MyClass159Criteria criteria) 
	{
		return this.myClass159Repository.findByCriteria (criteria);	
	}

	
	public MyClass159 findById (Long id) 
	{
		return this.myClass159Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass159 save (MyClass159 myclass159) 
	{
		return this.myClass159Repository.save (myclass159);	
	}


}
