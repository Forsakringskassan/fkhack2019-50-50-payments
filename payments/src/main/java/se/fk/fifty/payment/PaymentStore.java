package se.fk.fifty.payment;

import se.fk.fifty.payment.model.Payment;
import se.fk.fifty.payment.model.PaymentNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface PaymentStore
{
    /**
     * Retrieve payments for a specific customer id
     *
     * @param custId to retrieve payments
     * @return customers payments.
     */
    Map<String,Payment> getPayments(String custId);

    /**
     * Retrieve a payment by id.
     *
     * @param customerId customer
     * @param paymentId to retrieve.
     * @return payment if exists.
     * @throws PaymentNotFoundException
     */
    Payment getPayment(String customerId, String paymentId);

    /**
     * Remove a payment with the given id.
     *
     * @param customerId customer
     * @param paymentId of the payment to remove.
     */
    void cancelPayment(String customerId, String paymentId);

    /**
     * Create a new payment with the provided data.
     *
     * @param customerId customer
     * @param payment to create.
     * @return
     */
    Payment createPayment(String customerId, String paymentId, Payment payment);
}
