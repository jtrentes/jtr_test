package big.services;

import big.repositories.MyClass56Repository;
import java.util.List;
import big.domain.MyClass56;
import big.repositories.criteria.MyClass56Criteria;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass56Service")
@Transactional(readOnly = true)
public class MyClass56ServiceImpl implements MyClass56Service
{

	
	@Autowired
	private MyClass56Repository myClass56Repository;
    

	
	public List<MyClass56> findAll () 
	{
		return this.myClass56Repository.findAll();	
	}

	
	public List<MyClass56> findByCriteria (MyClass56Criteria criteria) 
	{
		return this.myClass56Repository.findByCriteria (criteria);	
	}

	
	public MyClass56 findById (Long id) 
	{
		return this.myClass56Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass56 save (MyClass56 myclass56) 
	{
		return this.myClass56Repository.save (myclass56);	
	}


}
