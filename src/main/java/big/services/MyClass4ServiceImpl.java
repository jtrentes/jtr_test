package big.services;

import big.repositories.MyClass4Repository;
import big.domain.MyClass4;
import java.util.List;
import big.repositories.criteria.MyClass4Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass4Service")
@Transactional(readOnly = true)
public class MyClass4ServiceImpl implements MyClass4Service
{

	
	@Autowired
	private MyClass4Repository myClass4Repository;
    

	
	public List<MyClass4> findAll () 
	{
		return this.myClass4Repository.findAll();	
	}

	
	public List<MyClass4> findByCriteria (MyClass4Criteria criteria) 
	{
		return this.myClass4Repository.findByCriteria (criteria);	
	}

	
	public MyClass4 findById (Long id) 
	{
		return this.myClass4Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass4 save (MyClass4 myclass4) 
	{
		return this.myClass4Repository.save (myclass4);	
	}


}
