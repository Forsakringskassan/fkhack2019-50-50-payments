package se.fk.fifty.payment;

import org.junit.Before;
import org.junit.Test;
import se.fk.fifty.payment.model.Payment;

import java.util.UUID;

import static org.junit.Assert.*;

public class PaymentStoreImplTest
{
    private PaymentStore instance;
    private String customerId = UUID.randomUUID().toString();
    private String paymentId = UUID.randomUUID().toString();
    private String data = "{ \"something\": \"really interesting.\" }";
    private Payment payment = new Payment( data );

    @Before
    public void setup()
    {
        instance = new PaymentStoreImpl();
    }

    @Test
    public void createPayment()
    {

        Payment created = instance.createPayment( customerId, paymentId, payment );

        assertEquals( created.getData(), data );

        assertEquals( instance.getPayments( customerId ).size(), 1 );
    }

    @Test
    public void getPayment()
    {
        instance.createPayment( customerId, paymentId, payment );
        instance.createPayment( "123", "321", new Payment( "{}") );

        assertEquals( instance.getPayment( customerId, paymentId ), payment );
    }

    @Test
    public void cancelPayment()
    {

        instance.createPayment( customerId, paymentId, payment );
        instance.createPayment( customerId, "321", new Payment( "{}") );

        assertEquals( instance.getPayments( customerId ).size(), 2 );
        instance.cancelPayment( customerId, "321");
        assertEquals( instance.getPayments( customerId ).size(), 1 );
        assertEquals( instance.getPayment( customerId, paymentId ), payment );
    }


}