package big.services;

import big.repositories.MyClass63Repository;
import java.util.List;
import big.domain.MyClass63;
import big.repositories.criteria.MyClass63Criteria;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass63Service")
@Transactional(readOnly = true)
public class MyClass63ServiceImpl implements MyClass63Service
{

	
	@Autowired
	private MyClass63Repository myClass63Repository;
    

	
	public List<MyClass63> findAll () 
	{
		return this.myClass63Repository.findAll();	
	}

	
	public List<MyClass63> findByCriteria (MyClass63Criteria criteria) 
	{
		return this.myClass63Repository.findByCriteria (criteria);	
	}

	
	public MyClass63 findById (Long id) 
	{
		return this.myClass63Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass63 save (MyClass63 myclass63) 
	{
		return this.myClass63Repository.save (myclass63);	
	}


}
