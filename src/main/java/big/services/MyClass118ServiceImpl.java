package big.services;

import java.util.List;
import big.domain.MyClass118;
import big.repositories.criteria.MyClass118Criteria;
import big.repositories.MyClass118Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass118Service")
@Transactional(readOnly = true)
public class MyClass118ServiceImpl implements MyClass118Service
{

	
	@Autowired
	private MyClass118Repository myClass118Repository;
    

	
	public List<MyClass118> findAll () 
	{
		return this.myClass118Repository.findAll();	
	}

	
	public List<MyClass118> findByCriteria (MyClass118Criteria criteria) 
	{
		return this.myClass118Repository.findByCriteria (criteria);	
	}

	
	public MyClass118 findById (Long id) 
	{
		return this.myClass118Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass118 save (MyClass118 myclass118) 
	{
		return this.myClass118Repository.save (myclass118);	
	}


}
