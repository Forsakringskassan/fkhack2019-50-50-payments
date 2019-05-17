package se.fk.fifty.payment;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class JsonMerger
{
    private JsonMerger()
    {

    }

    public static JsonObject merge( JsonObject base, JsonObject patch )
    {
        JsonObjectBuilder baseBuilder = Json.createObjectBuilder( base );
        JsonObjectBuilder patchBuilder = Json.createObjectBuilder( patch );

        return baseBuilder.addAll( patchBuilder ).build();
    }
}

