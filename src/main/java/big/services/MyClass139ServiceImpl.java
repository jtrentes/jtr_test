package big.services;

import java.util.List;
import big.domain.MyClass139;
import big.repositories.criteria.MyClass139Criteria;
import big.repositories.MyClass139Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass139Service")
@Transactional(readOnly = true)
public class MyClass139ServiceImpl implements MyClass139Service
{

	
	@Autowired
	private MyClass139Repository myClass139Repository;
    

	
	public List<MyClass139> findAll () 
	{
		return this.myClass139Repository.findAll();	
	}

	
	public List<MyClass139> findByCriteria (MyClass139Criteria criteria) 
	{
		return this.myClass139Repository.findByCriteria (criteria);	
	}

	
	public MyClass139 findById (Long id) 
	{
		return this.myClass139Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass139 save (MyClass139 myclass139) 
	{
		return this.myClass139Repository.save (myclass139);	
	}


}
