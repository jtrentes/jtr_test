package big.services;

import big.repositories.criteria.MyClass31Criteria;
import big.domain.MyClass31;
import java.util.List;
import big.repositories.MyClass31Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass31Service")
@Transactional(readOnly = true)
public class MyClass31ServiceImpl implements MyClass31Service
{

	
	@Autowired
	private MyClass31Repository myClass31Repository;
    

	
	public List<MyClass31> findAll () 
	{
		return this.myClass31Repository.findAll();	
	}

	
	public List<MyClass31> findByCriteria (MyClass31Criteria criteria) 
	{
		return this.myClass31Repository.findByCriteria (criteria);	
	}

	
	public MyClass31 findById (Long id) 
	{
		return this.myClass31Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass31 save (MyClass31 myclass31) 
	{
		return this.myClass31Repository.save (myclass31);	
	}


}
