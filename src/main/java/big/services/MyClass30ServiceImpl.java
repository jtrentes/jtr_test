package big.services;

import big.repositories.criteria.MyClass30Criteria;
import big.repositories.MyClass30Repository;
import big.domain.MyClass30;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass30Service")
@Transactional(readOnly = true)
public class MyClass30ServiceImpl implements MyClass30Service
{

	
	@Autowired
	private MyClass30Repository myClass30Repository;
    

	
	public List<MyClass30> findAll () 
	{
		return this.myClass30Repository.findAll();	
	}

	
	public List<MyClass30> findByCriteria (MyClass30Criteria criteria) 
	{
		return this.myClass30Repository.findByCriteria (criteria);	
	}

	
	public MyClass30 findById (Long id) 
	{
		return this.myClass30Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass30 save (MyClass30 myclass30) 
	{
		return this.myClass30Repository.save (myclass30);	
	}


}
