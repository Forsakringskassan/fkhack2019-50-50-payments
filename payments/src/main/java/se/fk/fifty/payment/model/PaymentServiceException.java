package se.fk.fifty.payment.model;

public class PaymentServiceException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public PaymentServiceException()
    {
    }

    public PaymentServiceException(String message)
    {
        super(message);
    }

    public PaymentServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PaymentServiceException(Throwable cause)
    {
        super(cause);
    }
}
