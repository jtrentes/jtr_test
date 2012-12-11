package big.services;

import big.repositories.criteria.MyClass158Criteria;
import java.util.List;
import big.domain.MyClass158;
import big.repositories.MyClass158Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass158Service")
@Transactional(readOnly = true)
public class MyClass158ServiceImpl implements MyClass158Service
{

	
	@Autowired
	private MyClass158Repository myClass158Repository;
    

	
	public List<MyClass158> findAll () 
	{
		return this.myClass158Repository.findAll();	
	}

	
	public List<MyClass158> findByCriteria (MyClass158Criteria criteria) 
	{
		return this.myClass158Repository.findByCriteria (criteria);	
	}

	
	public MyClass158 findById (Long id) 
	{
		return this.myClass158Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass158 save (MyClass158 myclass158) 
	{
		return this.myClass158Repository.save (myclass158);	
	}


}
