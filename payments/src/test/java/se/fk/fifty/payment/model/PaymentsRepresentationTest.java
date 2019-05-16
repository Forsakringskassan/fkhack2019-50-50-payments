package se.fk.fifty.payment.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.openapitools.jackson.dataformat.hal.HALMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

import static org.junit.Assert.*;

public class PaymentsRepresentationTest
{
    PaymentsRepresentation instance;
    ObjectMapper halMapper;

    @Before
    public void before() {
        halMapper = new HALMapper();
        instance = new PaymentsRepresentation( "123");
    }

    @Ignore
    @Test
    public void entrypoint_to_hal_json() throws Exception
    {
        //when
        String json = halMapper.writeValueAsString(instance);

        //then
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject root = reader.readObject();
        JsonObject links = root.getJsonObject("_links");

        assertEquals( links.getJsonObject("self").getString("href"),  "/" );

        JsonObject labelGroups = links.getJsonObject(Relationship.PAYMENTS);
        assertEquals( labelGroups.getString("href"), Relationship.PAYMENTS_CONTEXT + "/{"+Relationship.CUSTOMER_ID+"}" );
        assertTrue( labelGroups.containsKey( "templated" ) );
    }
}