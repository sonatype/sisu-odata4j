package org.odata4j.exceptions;

/*--------------------------- sisu-odata4j-patch ---------------------------*\
import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;
\*--------------------------------------------------------------------------*/

import org.odata4j.core.OError;

public class NotImplementedException extends ODataProducerException {

  private static final long serialVersionUID = 1L;

/*--------------------------- sisu-odata4j-patch ---------------------------*\
  // available in JAX-RS Version 2.0
  public static final StatusType NOT_IMPLEMENTED = new StatusType() {

    public int getStatusCode() {
      return 501;
    }

    public Family getFamily() {
      return Family.SERVER_ERROR;
    }

    public String getReasonPhrase() {
      return "Not Implemented";
    }
  };
\*--------------------------------------------------------------------------*/

  public NotImplementedException() {
    this(null, null);
  }

  public NotImplementedException(String message) {
    this(message, null);
  }

  public NotImplementedException(Throwable cause) {
    this(null, cause);
  }

  public NotImplementedException(String message, Throwable cause) {
    super(message, cause);
  }

/*--------------------------- sisu-odata4j-patch ---------------------------*\
  @Override
  public StatusType getHttpStatus() {
    return NOT_IMPLEMENTED;
  }
\*--------------------------------------------------------------------------*/

  private NotImplementedException(OError error) {
    super(error);
  }

  public static class Factory implements ExceptionFactory<NotImplementedException> {

    @Override
    public int getStatusCode() {
/*--------------------------- sisu-odata4j-patch ---------------------------*\
      return NOT_IMPLEMENTED.getStatusCode();
*/    return 501;
/*--------------------------------------------------------------------------*/
    }

    @Override
    public NotImplementedException createException(OError error) {
      return new NotImplementedException(error);
    }
  }
}
