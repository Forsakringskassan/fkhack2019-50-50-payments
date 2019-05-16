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

    public String getPaymentFrom()
    {
        return data.getString( "payment_from" );
    }

    public String getAmount()
    {
        return data.getString( "amount" );
    }

    public String getCurrency()
    {
        return data.getString( "currency" );
    }

    public String getCreatedDate()
    {
        return data.getString( "created_date" );
    }

    public String getPaymentDate()
    {
        return data.getString( "payment_date");
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
