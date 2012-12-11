package big.services;

import big.repositories.criteria.MyClass29Criteria;
import big.repositories.MyClass29Repository;
import big.domain.MyClass29;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass29Service")
@Transactional(readOnly = true)
public class MyClass29ServiceImpl implements MyClass29Service
{

	
	@Autowired
	private MyClass29Repository myClass29Repository;
    

	
	public List<MyClass29> findAll () 
	{
		return this.myClass29Repository.findAll();	
	}

	
	public List<MyClass29> findByCriteria (MyClass29Criteria criteria) 
	{
		return this.myClass29Repository.findByCriteria (criteria);	
	}

	
	public MyClass29 findById (Long id) 
	{
		return this.myClass29Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass29 save (MyClass29 myclass29) 
	{
		return this.myClass29Repository.save (myclass29);	
	}


}
