package io.github.server;

import org.apache.hc.core5.http.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

public class HttpResponseWrapper implements HttpResponse {

    private final ClassicHttpResponse classicHttpResponse;

    public HttpResponseWrapper(ClassicHttpResponse classicHttpResponse) {
        this.classicHttpResponse = classicHttpResponse;
    }

    @Override
    public void close() throws IOException {
        classicHttpResponse.close();
    }

    @Override
    public HttpEntity getEntity() {
        return classicHttpResponse.getEntity();
    }

    @Override
    public void setEntity(HttpEntity httpEntity) {
        classicHttpResponse.setEntity(httpEntity);
    }

    @Override
    public int getCode() {
        return classicHttpResponse.getCode();
    }

    @Override
    public void setCode(int i) {
        classicHttpResponse.setCode(i);
    }

    @Override
    public String getReasonPhrase() {
        return classicHttpResponse.getReasonPhrase();
    }

    @Override
    public void setReasonPhrase(String s) {
        classicHttpResponse.setReasonPhrase(s);
    }

    @Override
    public Locale getLocale() {
        return classicHttpResponse.getLocale();
    }

    @Override
    public void setLocale(Locale locale) {
        classicHttpResponse.setLocale(locale);
    }

    @Override
    public void setVersion(ProtocolVersion protocolVersion) {
        classicHttpResponse.setVersion(protocolVersion);
    }

    @Override
    public ProtocolVersion getVersion() {
        return classicHttpResponse.getVersion();
    }

    @Override
    public void addHeader(Header header) {
        classicHttpResponse.addHeader(header);
    }

    @Override
    public void addHeader(String s, Object o) {
        classicHttpResponse.addHeader(s, o);
    }

    @Override
    public void setHeader(Header header) {
        classicHttpResponse.setHeader(header);
    }

    @Override
    public void setHeader(String s, Object o) {
        classicHttpResponse.setHeader(s, o);
    }

    @Override
    public void setHeaders(Header... headers) {
        classicHttpResponse.setHeaders(headers);
    }

    @Override
    public boolean removeHeader(Header header) {
        return classicHttpResponse.removeHeader(header);
    }

    @Override
    public boolean removeHeaders(String s) {
        return classicHttpResponse.removeHeaders(s);
    }

    @Override
    public boolean containsHeader(String s) {
        return classicHttpResponse.containsHeader(s);
    }

    @Override
    public int countHeaders(String s) {
        return classicHttpResponse.countHeaders(s);
    }

    @Override
    public Header getFirstHeader(String s) {
        return classicHttpResponse.getFirstHeader(s);
    }

    @Override
    public Header getHeader(String s) throws ProtocolException {
        return classicHttpResponse.getHeader(s);
    }

    @Override
    public Header[] getHeaders() {
        return classicHttpResponse.getHeaders();
    }

    @Override
    public Header[] getHeaders(String s) {
        return classicHttpResponse.getHeaders(s);
    }

    @Override
    public Header getLastHeader(String s) {
        return classicHttpResponse.getLastHeader(s);
    }

    @Override
    public Iterator<Header> headerIterator() {
        return classicHttpResponse.headerIterator();
    }

    @Override
    public Iterator<Header> headerIterator(String s) {
        return classicHttpResponse.headerIterator(s);
    }
}
