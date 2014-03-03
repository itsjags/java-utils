package com.jags.javautils.xml;

import com.jags.javautils.Cast;
import com.jags.javautils.commons.ApplicationException;
import com.jags.javautils.errors.CommonErrors;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import static org.apache.commons.io.IOUtils.toInputStream;
import static org.apache.commons.lang3.Validate.*;

public class XmlModelFactory {
  private static final String IO_ERROR = "IOERROR";
  private static final String UTF_8 = "utf-8";
  private final Marshaller marshaller;
  private final Unmarshaller unmarshaller;

  public XmlModelFactory(final Marshaller marshaller, final Unmarshaller unmarshaller) {
    this.marshaller = marshaller;
    this.unmarshaller = unmarshaller;
  }

  public <T> T fromXml(final String xmlString, final Class<T> clazz) {
    notBlank(xmlString, "XML String");
    notNull(clazz, "clazz");
    isTrue(marshaller.supports(clazz), "class supported by marshaller/unmarshaller", clazz.getName());
    try {
      final StreamSource streamSource = toStreamSource(xmlString);
      final Object result = unmarshaller.unmarshal(streamSource);
      return Cast.to(result, clazz);
    } catch (IOException e) {
      throw ApplicationException
              .create(CommonErrors.IO_ERROR, "Caught JAXBException un-marshalling XML string into type", e);
    }
  }

  public <T> String toXml(final T t) {
    notNull(t, "type");
    try {
      final StringWriter stringWriter = new StringWriter();
      final Result result = new StreamResult(stringWriter);
      marshaller.marshal(t, result);
      return stringWriter.toString();
    } catch (final IOException e) {
      throw ApplicationException.create(CommonErrors.IO_ERROR,
                                        "Caught JAXBException marshalling object into XML string",
                                        e);
    }
  }

  private StreamSource toStreamSource(final String xmlString) throws IOException {
    return new StreamSource(
            toInputStreamReader(xmlString)
    );
  }

  private InputStreamReader toInputStreamReader(final String xmlString) throws IOException {
    return new InputStreamReader(toInputStream(xmlString, UTF_8)
            , UTF_8);
  }
}
