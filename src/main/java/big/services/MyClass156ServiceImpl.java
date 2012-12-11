package big.services;

import big.repositories.criteria.MyClass156Criteria;
import big.domain.MyClass156;
import java.util.List;
import big.repositories.MyClass156Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass156Service")
@Transactional(readOnly = true)
public class MyClass156ServiceImpl implements MyClass156Service
{

	
	@Autowired
	private MyClass156Repository myClass156Repository;
    

	
	public List<MyClass156> findAll () 
	{
		return this.myClass156Repository.findAll();	
	}

	
	public List<MyClass156> findByCriteria (MyClass156Criteria criteria) 
	{
		return this.myClass156Repository.findByCriteria (criteria);	
	}

	
	public MyClass156 findById (Long id) 
	{
		return this.myClass156Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass156 save (MyClass156 myclass156) 
	{
		return this.myClass156Repository.save (myclass156);	
	}


}
