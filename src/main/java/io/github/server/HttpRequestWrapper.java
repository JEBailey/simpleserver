package io.github.server;

import org.apache.hc.core5.http.*;
import org.apache.hc.core5.net.URIAuthority;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

public class HttpRequestWrapper implements HttpRequest {

    private final ClassicHttpRequest classicHttpRequest;

    public HttpRequestWrapper(ClassicHttpRequest classicHttpRequest) {
        this.classicHttpRequest = classicHttpRequest;
    }

    @Override
    public HttpEntity getEntity() {
        return classicHttpRequest.getEntity();
    }

    @Override
    public void setEntity(HttpEntity httpEntity) {
        classicHttpRequest.setEntity(httpEntity);
    }

    @Override
    public String getMethod() {
        return classicHttpRequest.getMethod();
    }

    @Override
    public String getPath() {
        return classicHttpRequest.getPath();
    }

    @Override
    public void setPath(String s) {
        classicHttpRequest.setPath(s);
    }

    @Override
    public String getScheme() {
        return classicHttpRequest.getScheme();
    }

    @Override
    public void setScheme(String s) {
        classicHttpRequest.setScheme(s);
    }

    @Override
    public URIAuthority getAuthority() {
        return classicHttpRequest.getAuthority();
    }

    @Override
    public void setAuthority(URIAuthority uriAuthority) {
        classicHttpRequest.setAuthority(uriAuthority);
    }

    @Override
    public String getRequestUri() {
        return classicHttpRequest.getRequestUri();
    }

    @Override
    public URI getUri() throws URISyntaxException {
        return classicHttpRequest.getUri();
    }

    @Override
    public void setUri(URI uri) {
        classicHttpRequest.setUri(uri);
    }

    @Override
    public void setVersion(ProtocolVersion protocolVersion) {
        classicHttpRequest.setVersion(protocolVersion);
    }

    @Override
    public ProtocolVersion getVersion() {
        return classicHttpRequest.getVersion();
    }

    @Override
    public void addHeader(Header header) {
        classicHttpRequest.addHeader(header);
    }

    @Override
    public void addHeader(String s, Object o) {
        classicHttpRequest.addHeader(s, o);
    }

    @Override
    public void setHeader(Header header) {
        classicHttpRequest.setHeader(header);
    }

    @Override
    public void setHeader(String s, Object o) {
        classicHttpRequest.setHeader(s, o);
    }

    @Override
    public void setHeaders(Header... headers) {
        classicHttpRequest.setHeaders(headers);
    }

    @Override
    public boolean removeHeader(Header header) {
        return classicHttpRequest.removeHeader(header);
    }

    @Override
    public boolean removeHeaders(String s) {
        return classicHttpRequest.removeHeaders(s);
    }

    @Override
    public boolean containsHeader(String s) {
        return classicHttpRequest.containsHeader(s);
    }

    @Override
    public int countHeaders(String s) {
        return classicHttpRequest.countHeaders(s);
    }

    @Override
    public Header getFirstHeader(String s) {
        return classicHttpRequest.getFirstHeader(s);
    }

    @Override
    public Header getHeader(String s) throws ProtocolException {
        return classicHttpRequest.getHeader(s);
    }

    @Override
    public Header[] getHeaders() {
        return classicHttpRequest.getHeaders();
    }

    @Override
    public Header[] getHeaders(String s) {
        return classicHttpRequest.getHeaders(s);
    }

    @Override
    public Header getLastHeader(String s) {
        return classicHttpRequest.getLastHeader(s);
    }

    @Override
    public Iterator<Header> headerIterator() {
        return classicHttpRequest.headerIterator();
    }

    @Override
    public Iterator<Header> headerIterator(String s) {
        return classicHttpRequest.headerIterator(s);
    }
}
