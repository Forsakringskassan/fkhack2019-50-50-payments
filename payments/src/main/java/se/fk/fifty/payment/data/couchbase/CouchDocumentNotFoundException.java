package se.fk.fifty.payment.data.couchbase;

public class CouchDocumentNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public CouchDocumentNotFoundException()
    {
    }

    public CouchDocumentNotFoundException(String message)
    {
        super(message);
    }

    public CouchDocumentNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CouchDocumentNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
