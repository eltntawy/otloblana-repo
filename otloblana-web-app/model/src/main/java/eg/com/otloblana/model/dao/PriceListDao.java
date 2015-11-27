package eg.com.otloblana.model.dao;

import eg.com.otloblana.common.Exception.AuthenticationException;
import eg.com.otloblana.common.Exception.DatabaseRollbackException;
import eg.com.otloblana.model.entity.GroupEntity;
import eg.com.otloblana.model.entity.PriceListEntity;
import eg.com.otloblana.model.entity.UserEntity;
import eg.com.otloblana.common.dao.GenericDao;

import java.util.List;
import java.util.Set;

/**
 * Created by Mohamed on 2015/07/04.
 */
public interface PriceListDao extends GenericDao<PriceListEntity> {


}
