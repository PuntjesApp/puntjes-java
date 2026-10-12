package app.puntjes.sdk.exceptions;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** HTTP 422 with VALIDATION_ERROR. Other 422 codes are refusals and throw {@link PuntjesException}. */
public final class ValidationException extends PuntjesException {
    private static final long serialVersionUID = 1L;

    private final LinkedHashMap<String, List<String>> details;

    public ValidationException(ApiError error) {
        super(error);
        this.details = new LinkedHashMap<>(error.details());
    }

    /** The messages of each rejected field, by field name. Empty when the response named no field. */
    public Map<String, List<String>> details() {
        return Collections.unmodifiableMap(details);
    }

    /** The messages for one field, or an empty list. */
    public List<String> errorsFor(String field) {
        return details.getOrDefault(field, List.of());
    }
}
