package se.fk.fifty.payment.data.couchbase;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.RawJsonDocument;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;

public class CouchClient
{

    private final Cluster cluster;
    private final Bucket paymentBucket;

    public CouchClient()
    {
        /*CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder()
                .queryEnabled(true)

                .build();
*/
        cluster = CouchbaseCluster.create( "192.168.99.100" );
        //cluster = CouchbaseCluster.create( "35.228.219.56" );
        //cluster = CouchbaseCluster.create( "10.51.247.187" );

        //ClusterManager manager = cluster.clusterManager("user123","user123");

        paymentBucket = cluster.openBucket( "payments" , "payments" );
    }

    public JsonObject createDocument(JsonObject json)
    {
        RawJsonDocument response = paymentBucket.upsert( RawJsonDocument.create( json.getString( "id"), json.toString() ) );

        return Json.createReader( new StringReader( response.content() ) ).readObject();
    }

    private JsonObject rawToObject( RawJsonDocument response )
    {
        return toJsonObject( response.content() );
    }

    private JsonObject toJsonObject( String src )
    {
        return Json.createReader( new StringReader( src ) ).readObject();
    }

    public JsonObject getDocument( String id )
    {
        RawJsonDocument doc = paymentBucket.get( id, RawJsonDocument.class );
        if( doc == null )
        {
            throw new CouchDocumentNotFoundException( "Unable to find document with id: " + id );
        }
        return rawToObject( doc );
    }
}
