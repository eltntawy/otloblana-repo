package eg.com.otloblana.model.dao;

import eg.com.otloblana.model.entity.GroupEntity;
import eg.com.otloblana.model.entity.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.Set;

/**
 * Created by Mohamed_2 on 11/20/2015.
 */
@Stateless(mappedName = "GroupDaoImpl")

public class GroupDaoImpl extends GenericDaoImpl<GroupEntity> implements GroupDao {
    public GroupDaoImpl() {
        super(GroupEntity.class);
    }


    @Override
    public Set<GroupEntity> getUserGroups(UserEntity userEntity) {

        Query query = entityManager.createQuery("Select gp From GroupEntity gp where :user in gp.me ");

        return null;
    }
}
