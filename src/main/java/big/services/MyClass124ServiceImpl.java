package big.services;

import java.util.List;
import big.domain.MyClass124;
import big.repositories.criteria.MyClass124Criteria;
import big.repositories.MyClass124Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass124Service")
@Transactional(readOnly = true)
public class MyClass124ServiceImpl implements MyClass124Service
{

	
	@Autowired
	private MyClass124Repository myClass124Repository;
    

	
	public List<MyClass124> findAll () 
	{
		return this.myClass124Repository.findAll();	
	}

	
	public List<MyClass124> findByCriteria (MyClass124Criteria criteria) 
	{
		return this.myClass124Repository.findByCriteria (criteria);	
	}

	
	public MyClass124 findById (Long id) 
	{
		return this.myClass124Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass124 save (MyClass124 myclass124) 
	{
		return this.myClass124Repository.save (myclass124);	
	}


}
