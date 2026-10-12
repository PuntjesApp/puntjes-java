import app.puntjes.sdk.IdempotencyKey;
import app.puntjes.sdk.PuntjesClientFactory;
import app.puntjes.sdk.PuntjesOptions;
import app.puntjes.sdk.exceptions.PuntjesException;
import app.puntjes.sdk.generated.PuntjesClient;
import app.puntjes.sdk.generated.models.CreateTransactionData;
import app.puntjes.sdk.generated.models.TransactionData;

public final class QuickStart {
    private QuickStart() {
    }

    /** Usage: {@code QuickStart <card or email> [amount in cents]}. */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: QuickStart <card or email> [amount in cents]");
            System.exit(2);
        }
        PuntjesOptions.Builder options = PuntjesOptions.builder();
        String baseUrl = System.getenv("PUNTJES_BASE_URL");
        if (baseUrl != null && !baseUrl.isBlank()) {
            options.baseUrl(baseUrl);
        }
        PuntjesClient puntjes = PuntjesClientFactory.create(
                System.getenv("PUNTJES_CLIENT_ID"), System.getenv("PUNTJES_CLIENT_SECRET"), options.build());

        try {
            var customer = puntjes.customers().lookup().get(c -> c.queryParameters.identifier = args[0]).getData();
            System.out.println("Balance before: " + customer.getWalletBalance());

            var purchase = new CreateTransactionData();
            purchase.setIdentifier(args[0]);
            purchase.setTotalAmount(args.length > 1 ? Integer.parseInt(args[1]) : 4200);
            purchase.setIdempotencyKey(IdempotencyKey.newKey());
            TransactionData transaction = puntjes.transactions().post(purchase).getData();
            System.out.println("Points earned: " + transaction.getPointsEarned());
        } catch (PuntjesException e) {
            System.err.println("Puntjes refused the call: " + e.getMessage() + " (request " + e.requestId().orElse("unknown") + ")");
            System.exit(1);
        }
    }
}
