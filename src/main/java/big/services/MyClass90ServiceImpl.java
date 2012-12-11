package big.services;

import big.domain.MyClass90;
import big.repositories.MyClass90Repository;
import java.util.List;
import big.repositories.criteria.MyClass90Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass90Service")
@Transactional(readOnly = true)
public class MyClass90ServiceImpl implements MyClass90Service
{

	
	@Autowired
	private MyClass90Repository myClass90Repository;
    

	
	public List<MyClass90> findAll () 
	{
		return this.myClass90Repository.findAll();	
	}

	
	public List<MyClass90> findByCriteria (MyClass90Criteria criteria) 
	{
		return this.myClass90Repository.findByCriteria (criteria);	
	}

	
	public MyClass90 findById (Long id) 
	{
		return this.myClass90Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass90 save (MyClass90 myclass90) 
	{
		return this.myClass90Repository.save (myclass90);	
	}


}
