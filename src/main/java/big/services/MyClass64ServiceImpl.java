package big.services;

import big.repositories.criteria.MyClass64Criteria;
import big.domain.MyClass64;
import big.repositories.MyClass64Repository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass64Service")
@Transactional(readOnly = true)
public class MyClass64ServiceImpl implements MyClass64Service
{

	
	@Autowired
	private MyClass64Repository myClass64Repository;
    

	
	public List<MyClass64> findAll () 
	{
		return this.myClass64Repository.findAll();	
	}

	
	public List<MyClass64> findByCriteria (MyClass64Criteria criteria) 
	{
		return this.myClass64Repository.findByCriteria (criteria);	
	}

	
	public MyClass64 findById (Long id) 
	{
		return this.myClass64Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass64 save (MyClass64 myclass64) 
	{
		return this.myClass64Repository.save (myclass64);	
	}


}
