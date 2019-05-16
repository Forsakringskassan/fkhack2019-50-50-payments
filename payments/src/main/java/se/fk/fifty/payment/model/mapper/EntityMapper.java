package se.fk.fifty.payment.model.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.openapitools.jackson.dataformat.hal.HALMapper;

import java.io.IOException;

/**
 * Hack because I can't get the Jackson provider to register.
 */
public final class EntityMapper
{
    private static final ObjectMapper mapper = new HALMapper();

    private EntityMapper()
    {

    }

    public static String toHalJson(Object t)
    {
        try
        {
            return mapper.writeValueAsString(t);
        } catch (JsonProcessingException e)
        {
            throw new EntityMapperException(e);
        }
    }

    public static <T> T fromHalJson(String json, Class<T> type)
    {
        try
        {
            return mapper.readValue(json, type);
        } catch (IOException e)
        {
            throw new EntityMapperException(e);
        }
    }
}

