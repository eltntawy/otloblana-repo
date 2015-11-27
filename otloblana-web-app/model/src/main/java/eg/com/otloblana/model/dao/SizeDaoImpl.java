package eg.com.otloblana.model.dao;



import eg.com.otloblana.common.Exception.DatabaseRollbackException;
import eg.com.otloblana.model.entity.GroupEntity;
import eg.com.otloblana.model.entity.SizeEntity;
import eg.com.otloblana.model.entity.UserEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

/**
 * Created by Mohamed on 2015/07/04.
 */
@Stateless(mappedName = "SizeDaoImpl")
public class SizeDaoImpl extends GenericDaoImpl<SizeEntity> implements SizeDao {


    public SizeDaoImpl() {
        super(SizeEntity.class);
    }

}
