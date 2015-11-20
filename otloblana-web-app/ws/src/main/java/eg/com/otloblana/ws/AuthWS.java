package eg.com.otloblana.ws;

import eg.com.otloblana.common.Exception.ServiceException;
import eg.com.otloblana.common.rest.ResponseEntity;
import eg.com.otloblana.model.dto.UserDto;
import eg.com.otloblana.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * Created by Mohamed_2 on 11/14/2015.
 */
@Path("/Auth")
public class AuthWS {

    @Inject
    UserService userService;

    @GET
    @Produces("application/json")
    public ResponseEntity<UserDto> getUser(@QueryParam("username") String username, @QueryParam("password") String password) {

        UserDto userDto = null;
        ResponseEntity<UserDto> responseEntity = new ResponseEntity<UserDto>();
        try {
            userDto = userService.authenticateByUsername(username, password);

            responseEntity.setError(false);
            responseEntity.setObject(userDto);


        } catch (ServiceException e) {
            e.printStackTrace();
            responseEntity.setError(true);
            responseEntity.setErrorMessage("Unexpected error has been occurred please try again later");
            responseEntity.setObject(null);
            responseEntity.setTechnicalErrorMessage(e.getMessage());
        }

        return responseEntity;
    }
}
