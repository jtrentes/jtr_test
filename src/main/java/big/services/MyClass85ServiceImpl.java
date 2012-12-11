package big.services;

import big.repositories.MyClass85Repository;
import big.repositories.criteria.MyClass85Criteria;
import java.util.List;
import big.domain.MyClass85;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass85Service")
@Transactional(readOnly = true)
public class MyClass85ServiceImpl implements MyClass85Service
{

	
	@Autowired
	private MyClass85Repository myClass85Repository;
    

	
	public List<MyClass85> findAll () 
	{
		return this.myClass85Repository.findAll();	
	}

	
	public List<MyClass85> findByCriteria (MyClass85Criteria criteria) 
	{
		return this.myClass85Repository.findByCriteria (criteria);	
	}

	
	public MyClass85 findById (Long id) 
	{
		return this.myClass85Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass85 save (MyClass85 myclass85) 
	{
		return this.myClass85Repository.save (myclass85);	
	}


}
