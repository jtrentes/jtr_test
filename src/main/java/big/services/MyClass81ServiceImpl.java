package big.services;

import java.util.List;
import big.repositories.MyClass81Repository;
import big.repositories.criteria.MyClass81Criteria;
import big.domain.MyClass81;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass81Service")
@Transactional(readOnly = true)
public class MyClass81ServiceImpl implements MyClass81Service
{

	
	@Autowired
	private MyClass81Repository myClass81Repository;
    

	
	public List<MyClass81> findAll () 
	{
		return this.myClass81Repository.findAll();	
	}

	
	public List<MyClass81> findByCriteria (MyClass81Criteria criteria) 
	{
		return this.myClass81Repository.findByCriteria (criteria);	
	}

	
	public MyClass81 findById (Long id) 
	{
		return this.myClass81Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass81 save (MyClass81 myclass81) 
	{
		return this.myClass81Repository.save (myclass81);	
	}


}
