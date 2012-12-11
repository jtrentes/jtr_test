package big.services;

import big.repositories.criteria.MyClass148Criteria;
import big.repositories.MyClass148Repository;
import java.util.List;
import big.domain.MyClass148;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass148Service")
@Transactional(readOnly = true)
public class MyClass148ServiceImpl implements MyClass148Service
{

	
	@Autowired
	private MyClass148Repository myClass148Repository;
    

	
	public List<MyClass148> findAll () 
	{
		return this.myClass148Repository.findAll();	
	}

	
	public List<MyClass148> findByCriteria (MyClass148Criteria criteria) 
	{
		return this.myClass148Repository.findByCriteria (criteria);	
	}

	
	public MyClass148 findById (Long id) 
	{
		return this.myClass148Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass148 save (MyClass148 myclass148) 
	{
		return this.myClass148Repository.save (myclass148);	
	}


}
