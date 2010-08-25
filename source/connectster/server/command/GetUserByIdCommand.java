package connectster.server.command;

import connectster.api.IResponse;
import connectster.api.entity.IUser;
import connectster.api.entity.implementation.UserDTO;
import connectster.server.ICommand;
import connectster.server.Response;
import connectster.server.entity.User;
import connectster.server.exceptions.ConnectsterException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.Map;

/**
 * Copyright 2010 Shopster E-Commerce Inc.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class GetUserByIdCommand
implements ICommand<IUser>
{
    @Override
    public IResponse<IUser> execute( Session session, Map<String, Object> parameters )
    {
        long userId = ( Long )parameters.get( ICommand.PARAMETER_USER_ID );

        try
        {
            Criteria userCriteria = session.createCriteria( User.class );
            userCriteria.add( Restrictions.eq( "id", userId ) );
            User user = ( User )userCriteria.uniqueResult( );
            if( user == null )
            {
                throw new ConnectsterException( "User does not exist in database." );
            }

            return new Response<IUser>( new UserDTO( user ), IResponse.Status.Successful, "Found User: " + user.getName( ) );
        }
        catch( Exception x )
        {
            return new Response<IUser>( null, IResponse.Status.Failure, "User not found for id: " + userId + ", Reason: "
                + x.getMessage( ) );
        }
    }
}
