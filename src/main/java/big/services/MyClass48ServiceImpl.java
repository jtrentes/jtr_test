package big.services;

import java.util.List;
import big.domain.MyClass48;
import big.repositories.criteria.MyClass48Criteria;
import big.repositories.MyClass48Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass48Service")
@Transactional(readOnly = true)
public class MyClass48ServiceImpl implements MyClass48Service
{

	
	@Autowired
	private MyClass48Repository myClass48Repository;
    

	
	public List<MyClass48> findAll () 
	{
		return this.myClass48Repository.findAll();	
	}

	
	public List<MyClass48> findByCriteria (MyClass48Criteria criteria) 
	{
		return this.myClass48Repository.findByCriteria (criteria);	
	}

	
	public MyClass48 findById (Long id) 
	{
		return this.myClass48Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass48 save (MyClass48 myclass48) 
	{
		return this.myClass48Repository.save (myclass48);	
	}


}
