package big.services;

import java.util.List;
import big.repositories.criteria.MyClass14Criteria;
import big.domain.MyClass14;
import big.repositories.MyClass14Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass14Service")
@Transactional(readOnly = true)
public class MyClass14ServiceImpl implements MyClass14Service
{

	
	@Autowired
	private MyClass14Repository myClass14Repository;
    

	
	public List<MyClass14> findAll () 
	{
		return this.myClass14Repository.findAll();	
	}

	
	public List<MyClass14> findByCriteria (MyClass14Criteria criteria) 
	{
		return this.myClass14Repository.findByCriteria (criteria);	
	}

	
	public MyClass14 findById (Long id) 
	{
		return this.myClass14Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass14 save (MyClass14 myclass14) 
	{
		return this.myClass14Repository.save (myclass14);	
	}


}
