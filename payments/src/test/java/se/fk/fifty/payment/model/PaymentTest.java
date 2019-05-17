package se.fk.fifty.payment.model;

import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;

import java.util.UUID;

import static org.junit.Assert.*;

public class PaymentTest
{

    @Before
    public void setup()
    {

    }

    @Test
    public void getId()
    {
        String id = UUID.randomUUID().toString();
        JsonObject data = Json.createObjectBuilder().add( "id", id ).build();
        Payment instance = new Payment( data );

        assertEquals( instance.getId(), id );
    }

}