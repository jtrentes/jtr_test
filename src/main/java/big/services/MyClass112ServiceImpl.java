package big.services;

import big.repositories.MyClass112Repository;
import java.util.List;
import big.domain.MyClass112;
import big.repositories.criteria.MyClass112Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass112Service")
@Transactional(readOnly = true)
public class MyClass112ServiceImpl implements MyClass112Service
{

	
	@Autowired
	private MyClass112Repository myClass112Repository;
    

	
	public List<MyClass112> findAll () 
	{
		return this.myClass112Repository.findAll();	
	}

	
	public List<MyClass112> findByCriteria (MyClass112Criteria criteria) 
	{
		return this.myClass112Repository.findByCriteria (criteria);	
	}

	
	public MyClass112 findById (Long id) 
	{
		return this.myClass112Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass112 save (MyClass112 myclass112) 
	{
		return this.myClass112Repository.save (myclass112);	
	}


}
