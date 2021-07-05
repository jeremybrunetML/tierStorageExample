package com.marklogic.sample;

// IMPORTANT: Do not edit. This file is generated.

import com.marklogic.client.io.Format;
import java.io.Reader;


import com.marklogic.client.DatabaseClient;
import com.marklogic.client.io.marker.JSONWriteHandle;

import com.marklogic.client.impl.BaseProxy;

/**
 * Provides a set of operations on the database server
 */
public interface Api {
    /**
     * Creates a Api object for executing operations on the database server.
     *
     * The DatabaseClientFactory class can create the DatabaseClient parameter. A single
     * client object can be used for any number of requests and in multiple threads.
     *
     * @param db	provides a client for communicating with the database server
     * @return	an object for executing database operations
     */
    static Api on(DatabaseClient db) {
      return on(db, null);
    }
    /**
     * Creates a Api object for executing operations on the database server.
     *
     * The DatabaseClientFactory class can create the DatabaseClient parameter. A single
     * client object can be used for any number of requests and in multiple threads.
     *
     * The service declaration uses a custom implementation of the same service instead
     * of the default implementation of the service by specifying an endpoint directory
     * in the modules database with the implementation. A service.json file with the
     * declaration can be read with FileHandle or a string serialization of the JSON
     * declaration with StringHandle.
     *
     * @param db	provides a client for communicating with the database server
     * @param serviceDeclaration	substitutes a custom implementation of the service
     * @return	an object for executing database operations
     */
    static Api on(DatabaseClient db, JSONWriteHandle serviceDeclaration) {
        final class ApiImpl implements Api {
            private DatabaseClient dbClient;
            private BaseProxy baseProxy;

            private BaseProxy.DBFunctionRequest req_getContrats;
            private BaseProxy.DBFunctionRequest req_getCountForCollection;

            private ApiImpl(DatabaseClient dbClient, JSONWriteHandle servDecl) {
                this.dbClient  = dbClient;
                this.baseProxy = new BaseProxy("/api/", servDecl);

                this.req_getContrats = this.baseProxy.request(
                    "getContrats.sjs", BaseProxy.ParameterValuesKind.MULTIPLE_ATOMICS);
                this.req_getCountForCollection = this.baseProxy.request(
                    "getCountForCollection.sjs", BaseProxy.ParameterValuesKind.SINGLE_ATOMIC);
            }

            @Override
            public Reader getContrats(String range, String q, String sort) {
                return getContrats(
                    this.req_getContrats.on(this.dbClient), range, q, sort
                    );
            }
            private Reader getContrats(BaseProxy.DBFunctionRequest request, String range, String q, String sort) {
              return BaseProxy.JsonDocumentType.toReader(
                request
                      .withParams(
                          BaseProxy.atomicParam("range", true, BaseProxy.StringType.fromString(range)),
                          BaseProxy.atomicParam("q", true, BaseProxy.StringType.fromString(q)),
                          BaseProxy.atomicParam("sort", true, BaseProxy.StringType.fromString(sort))
                          ).responseSingle(false, Format.JSON)
                );
            }

            @Override
            public Integer getCountForCollection(String collection) {
                return getCountForCollection(
                    this.req_getCountForCollection.on(this.dbClient), collection
                    );
            }
            private Integer getCountForCollection(BaseProxy.DBFunctionRequest request, String collection) {
              return BaseProxy.IntegerType.toInteger(
                request
                      .withParams(
                          BaseProxy.atomicParam("collection", false, BaseProxy.StringType.fromString(collection))
                          ).responseSingle(false, null)
                );
            }
        }

        return new ApiImpl(db, serviceDeclaration);
    }

  /**
   * Invokes the getContrats operation on the database server
   *
   * @param range	provides input
   * @param q	provides input
   * @param sort	provides input
   * @return	as output
   */
    Reader getContrats(String range, String q, String sort);

  /**
   * Invokes the getCountForCollection operation on the database server
   *
   * @param collection	provides input
   * @return	as output
   */
    Integer getCountForCollection(String collection);

}
