package big.services;

import java.util.List;
import big.domain.MyClass157;
import big.repositories.criteria.MyClass157Criteria;
import big.repositories.MyClass157Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass157Service")
@Transactional(readOnly = true)
public class MyClass157ServiceImpl implements MyClass157Service
{

	
	@Autowired
	private MyClass157Repository myClass157Repository;
    

	
	public List<MyClass157> findAll () 
	{
		return this.myClass157Repository.findAll();	
	}

	
	public List<MyClass157> findByCriteria (MyClass157Criteria criteria) 
	{
		return this.myClass157Repository.findByCriteria (criteria);	
	}

	
	public MyClass157 findById (Long id) 
	{
		return this.myClass157Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass157 save (MyClass157 myclass157) 
	{
		return this.myClass157Repository.save (myclass157);	
	}


}
