package se.fk.fifty.payment.model;

import javax.json.JsonObject;
import java.util.Objects;

public class Payment
{
    private final JsonObject data;

    public Payment( JsonObject data )
    {
        this.data = data;
    }

    public JsonObject getData()
    {
        return data;
    }

    public String getId()
    {
        return data.getString( "id");
    }

    public String getPaymentTo()
    {
        return data.getString( "payment_to" );
    }

    public String getDescription()
    {
        return data.getString( "description" );
    }

    public String getStatus()
    {
        return data.getString( "status" );
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Payment payment = (Payment) o;
        return Objects.equals(data, payment.data);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(data);
    }

    @Override
    public String toString()
    {
        return "Payment{" +
                "data='" + data + '\'' +
                '}';
    }
}
