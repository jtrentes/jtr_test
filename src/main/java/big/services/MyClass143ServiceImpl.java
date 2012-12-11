package big.services;

import big.repositories.criteria.MyClass143Criteria;
import big.domain.MyClass143;
import big.repositories.MyClass143Repository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass143Service")
@Transactional(readOnly = true)
public class MyClass143ServiceImpl implements MyClass143Service
{

	
	@Autowired
	private MyClass143Repository myClass143Repository;
    

	
	public List<MyClass143> findAll () 
	{
		return this.myClass143Repository.findAll();	
	}

	
	public List<MyClass143> findByCriteria (MyClass143Criteria criteria) 
	{
		return this.myClass143Repository.findByCriteria (criteria);	
	}

	
	public MyClass143 findById (Long id) 
	{
		return this.myClass143Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass143 save (MyClass143 myclass143) 
	{
		return this.myClass143Repository.save (myclass143);	
	}


}
