package big.services;

import big.repositories.criteria.MyClass82Criteria;
import big.domain.MyClass82;
import java.util.List;
import big.repositories.MyClass82Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass82Service")
@Transactional(readOnly = true)
public class MyClass82ServiceImpl implements MyClass82Service
{

	
	@Autowired
	private MyClass82Repository myClass82Repository;
    

	
	public List<MyClass82> findAll () 
	{
		return this.myClass82Repository.findAll();	
	}

	
	public List<MyClass82> findByCriteria (MyClass82Criteria criteria) 
	{
		return this.myClass82Repository.findByCriteria (criteria);	
	}

	
	public MyClass82 findById (Long id) 
	{
		return this.myClass82Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass82 save (MyClass82 myclass82) 
	{
		return this.myClass82Repository.save (myclass82);	
	}


}
