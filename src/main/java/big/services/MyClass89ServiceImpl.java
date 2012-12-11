package big.services;

import big.repositories.criteria.MyClass89Criteria;
import big.repositories.MyClass89Repository;
import big.domain.MyClass89;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass89Service")
@Transactional(readOnly = true)
public class MyClass89ServiceImpl implements MyClass89Service
{

	
	@Autowired
	private MyClass89Repository myClass89Repository;
    

	
	public List<MyClass89> findAll () 
	{
		return this.myClass89Repository.findAll();	
	}

	
	public List<MyClass89> findByCriteria (MyClass89Criteria criteria) 
	{
		return this.myClass89Repository.findByCriteria (criteria);	
	}

	
	public MyClass89 findById (Long id) 
	{
		return this.myClass89Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass89 save (MyClass89 myclass89) 
	{
		return this.myClass89Repository.save (myclass89);	
	}


}
