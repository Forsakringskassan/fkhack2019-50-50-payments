package se.fk.fifty.payment;

import se.fk.fifty.payment.model.Payment;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PaymentStoreImpl implements PaymentStore
{


    @Override
    public List<Payment> getPayments(String custId)
    {
        return null;
    }

    @Override
    public Payment getPayment(String paymentId)
    {
        return null;
    }

    @Override
    public void cancelPayment(String paymentId)
    {

    }

    @Override
    public Payment createPayment(Payment payment)
    {
        return null;
    }
}
