package uk.gov.hmcts.reform.dev.restapi.controllers;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
