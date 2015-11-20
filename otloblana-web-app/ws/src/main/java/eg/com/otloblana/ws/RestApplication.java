package eg.com.otloblana.ws;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mohamed_2 on 11/14/2015.
 */
@ApplicationPath("/rest")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> classes = new HashSet<>();
        classes.add(AuthWS.class);

        return classes;
    }
}
