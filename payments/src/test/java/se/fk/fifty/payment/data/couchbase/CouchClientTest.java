package se.fk.fifty.payment.data.couchbase;

import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;

import java.util.UUID;

import static org.junit.Assert.*;

public class CouchClientTest
{

    CouchClient client;

    @Before
    public void setup()
    {
        client = new CouchClient();
    }

    @Test
    public void createDocument()
    {
        JsonObject data = Json.createObjectBuilder().add( "id", UUID.randomUUID().toString() ).build();
        client.createDocument( data );
    }


}