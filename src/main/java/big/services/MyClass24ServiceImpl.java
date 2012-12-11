package big.services;

import big.repositories.criteria.MyClass24Criteria;
import java.util.List;
import big.domain.MyClass24;
import big.repositories.MyClass24Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass24Service")
@Transactional(readOnly = true)
public class MyClass24ServiceImpl implements MyClass24Service
{

	
	@Autowired
	private MyClass24Repository myClass24Repository;
    

	
	public List<MyClass24> findAll () 
	{
		return this.myClass24Repository.findAll();	
	}

	
	public List<MyClass24> findByCriteria (MyClass24Criteria criteria) 
	{
		return this.myClass24Repository.findByCriteria (criteria);	
	}

	
	public MyClass24 findById (Long id) 
	{
		return this.myClass24Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass24 save (MyClass24 myclass24) 
	{
		return this.myClass24Repository.save (myclass24);	
	}


}
