package big.services;

import big.repositories.MyClass3Repository;
import big.repositories.criteria.MyClass3Criteria;
import big.domain.MyClass3;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass3Service")
@Transactional(readOnly = true)
public class MyClass3ServiceImpl implements MyClass3Service
{

	
	@Autowired
	private MyClass3Repository myClass3Repository;
    

	
	public List<MyClass3> findAll () 
	{
		return this.myClass3Repository.findAll();	
	}

	
	public List<MyClass3> findByCriteria (MyClass3Criteria criteria) 
	{
		return this.myClass3Repository.findByCriteria (criteria);	
	}

	
	public MyClass3 findById (Long id) 
	{
		return this.myClass3Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass3 save (MyClass3 myclass3) 
	{
		return this.myClass3Repository.save (myclass3);	
	}


}
