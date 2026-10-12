package app.puntjes.sdk.exceptions;

/** HTTP 429 with PLAN_LIMIT_EXCEEDED: the plan of the shop is used up. Waiting does not clear it. */
public final class PlanLimitExceededException extends PuntjesException {
    private static final long serialVersionUID = 1L;

    public PlanLimitExceededException(ApiError error) {
        super(error);
    }
}
