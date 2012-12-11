package big.services;

import java.util.List;
import big.repositories.MyClass105Repository;
import big.repositories.criteria.MyClass105Criteria;
import big.domain.MyClass105;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass105Service")
@Transactional(readOnly = true)
public class MyClass105ServiceImpl implements MyClass105Service
{

	
	@Autowired
	private MyClass105Repository myClass105Repository;
    

	
	public List<MyClass105> findAll () 
	{
		return this.myClass105Repository.findAll();	
	}

	
	public List<MyClass105> findByCriteria (MyClass105Criteria criteria) 
	{
		return this.myClass105Repository.findByCriteria (criteria);	
	}

	
	public MyClass105 findById (Long id) 
	{
		return this.myClass105Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass105 save (MyClass105 myclass105) 
	{
		return this.myClass105Repository.save (myclass105);	
	}


}
