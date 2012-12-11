package big.services;

import big.repositories.MyClass98Repository;
import java.util.List;
import big.repositories.criteria.MyClass98Criteria;
import big.domain.MyClass98;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass98Service")
@Transactional(readOnly = true)
public class MyClass98ServiceImpl implements MyClass98Service
{

	
	@Autowired
	private MyClass98Repository myClass98Repository;
    

	
	public List<MyClass98> findAll () 
	{
		return this.myClass98Repository.findAll();	
	}

	
	public List<MyClass98> findByCriteria (MyClass98Criteria criteria) 
	{
		return this.myClass98Repository.findByCriteria (criteria);	
	}

	
	public MyClass98 findById (Long id) 
	{
		return this.myClass98Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass98 save (MyClass98 myclass98) 
	{
		return this.myClass98Repository.save (myclass98);	
	}


}
