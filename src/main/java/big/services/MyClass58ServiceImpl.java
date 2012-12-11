package big.services;

import java.util.List;
import big.domain.MyClass58;
import big.repositories.criteria.MyClass58Criteria;
import big.repositories.MyClass58Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass58Service")
@Transactional(readOnly = true)
public class MyClass58ServiceImpl implements MyClass58Service
{

	
	@Autowired
	private MyClass58Repository myClass58Repository;
    

	
	public List<MyClass58> findAll () 
	{
		return this.myClass58Repository.findAll();	
	}

	
	public List<MyClass58> findByCriteria (MyClass58Criteria criteria) 
	{
		return this.myClass58Repository.findByCriteria (criteria);	
	}

	
	public MyClass58 findById (Long id) 
	{
		return this.myClass58Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass58 save (MyClass58 myclass58) 
	{
		return this.myClass58Repository.save (myclass58);	
	}


}
