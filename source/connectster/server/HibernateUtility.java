package connectster.server;

import connectster.server.entity.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import java.io.File;
import java.util.List;

/** Copyright 2010 Shopster E-Commerce Inc.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
public class HibernateUtility
{
	private static SessionFactory factory;
	private static AnnotationConfiguration configuration;

	static
	{
        // create new annotation config and add each persisted entity to it
		configuration = new AnnotationConfiguration( );
        configuration.addAnnotatedClass( AdapterData.class );
        configuration.addAnnotatedClass( AdapterDetails.class );
        configuration.addAnnotatedClass( AdapterProperty.class );
        configuration.addAnnotatedClass( Product.class );
        configuration.addAnnotatedClass( ProductMapping.class );
        configuration.addAnnotatedClass( User.class );
        configuration.addAnnotatedClass( UserMapping.class );
        configuration.addAnnotatedClass( UserProperty.class );
        configuration.addAnnotatedClass( Order.class );
        configuration.addAnnotatedClass( OrderItem.class );
        configuration.addAnnotatedClass( OrderMapping.class );

        // initialize configuration and build session factory
		configuration.configure( new File( "./configuration/hibernate.hbm.xml" ) );
		factory = configuration.buildSessionFactory( );
	}

    public static Session createSession( )
    {
        return factory.openSession( );
    }

	public static Session getSession( )
	{
		return factory.getCurrentSession( );
	}

	public static void createDatabase( )
	{
		SchemaExport schema = new SchemaExport( configuration );
		schema.create( true, true );
	}

	public static Transaction transaction( )
	{
		return getSession( ).beginTransaction( );
	}

	public static void commit( )
	{
		getSession( ).getTransaction( ).commit( );
	}

    public static void persist( Object ... objects )
    {
        Transaction transaction = transaction( );

        try
        {
            for( Object object : objects )
            {
                getSession( ).saveOrUpdate( object );                                                   
            }

            transaction.commit( );
        }
        catch( Exception x )
        {
            if( transaction != null )
            {
                transaction.rollback( );
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <E> void execute(String select, IterativeUnitOfWork<E> uow)
    {
        Transaction transaction = null;
        try
        {
            transaction = getSession( ).beginTransaction( );
            Query query = getSession( ).createQuery( select );
            List<E> results = ( List<E> )query.list( );
            transaction.commit();

            for( E row : results )
            {
                uow.next( row );
            }
        }
        catch( Exception x )
        {
            try
            {
                if( transaction != null )
                {
                    transaction.rollback( );
                }
            }
            finally
            {
                uow.onError( x );
            }
        }
    }
}
