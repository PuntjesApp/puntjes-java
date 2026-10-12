package app.puntjes.sdk;

import app.puntjes.sdk.generated.PuntjesClient;
import com.microsoft.kiota.RequestAdapter;

final class FactoryClient extends PuntjesClient {
    FactoryClient(RequestAdapter adapter) {
        super(adapter);
    }

    RequestAdapter adapter() {
        return requestAdapter;
    }
}
