package se.fk.fifty.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.openapitools.jackson.dataformat.hal.HALLink;
import io.openapitools.jackson.dataformat.hal.annotation.Link;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BaseRepresentation
{
    @Link
    private HALLink self;

    @Link
    private List<HALLink> curies;

    public BaseRepresentation()
    {
        curies = new ArrayList<>();
        HALLink rel = new HALLink.Builder("/docs/{rel}").name(Relationship.NAMESPACE).build();
        curies.add(rel);
    }

    @JsonIgnore
    public abstract String getSelfLink();

    public HALLink getSelf()
    {
        if (self == null)
        {
            self = new HALLink.Builder(URI.create(getSelfLink())).build();
        }
        return self;
    }

    public List<HALLink> getCuries()
    {
        return curies;
    }

    public BaseRepresentation setContext(BaseRepresentation representation)
    {
        self = new HALLink.Builder(URI.create(representation.getSelfLink() + getSelfLink())).build();

        return this;
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
        BaseRepresentation that = (BaseRepresentation) o;
        return Objects.equals(getSelf(), that.getSelf());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(self);
    }
}

