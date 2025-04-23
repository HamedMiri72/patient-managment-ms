package com.pm.patient_service.exception;

import java.util.Map;

public record ResponseError(
        Map<String, String> errors
) {
}
