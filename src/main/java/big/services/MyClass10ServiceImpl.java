package big.services;

import big.domain.MyClass10;
import big.repositories.criteria.MyClass10Criteria;
import big.repositories.MyClass10Repository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass10Service")
@Transactional(readOnly = true)
public class MyClass10ServiceImpl implements MyClass10Service
{

	
	@Autowired
	private MyClass10Repository myClass10Repository;
    

	
	public List<MyClass10> findAll () 
	{
		return this.myClass10Repository.findAll();	
	}

	
	public List<MyClass10> findByCriteria (MyClass10Criteria criteria) 
	{
		return this.myClass10Repository.findByCriteria (criteria);	
	}

	
	public MyClass10 findById (Long id) 
	{
		return this.myClass10Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass10 save (MyClass10 myclass10) 
	{
		return this.myClass10Repository.save (myclass10);	
	}


}
