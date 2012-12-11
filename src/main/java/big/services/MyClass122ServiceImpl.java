package big.services;

import java.util.List;
import big.domain.MyClass122;
import big.repositories.MyClass122Repository;
import big.repositories.criteria.MyClass122Criteria;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass122Service")
@Transactional(readOnly = true)
public class MyClass122ServiceImpl implements MyClass122Service
{

	
	@Autowired
	private MyClass122Repository myClass122Repository;
    

	
	public List<MyClass122> findAll () 
	{
		return this.myClass122Repository.findAll();	
	}

	
	public List<MyClass122> findByCriteria (MyClass122Criteria criteria) 
	{
		return this.myClass122Repository.findByCriteria (criteria);	
	}

	
	public MyClass122 findById (Long id) 
	{
		return this.myClass122Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass122 save (MyClass122 myclass122) 
	{
		return this.myClass122Repository.save (myclass122);	
	}


}
