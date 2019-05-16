package se.fk.fifty.payment.model;

import java.util.Objects;

public class Payment
{
    private final String data;

    public Payment( String data )
    {
        this.data = data;
    }

    public String getData()
    {
        return data;
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
