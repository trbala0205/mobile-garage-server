package requests;

import ai.api.model.AIResponse;

/**
 * Web-hook request model class
 */
public class AIWebhookRequest extends AIResponse {
    private static final long serialVersionUID = 1L;

    private OriginalRequest originalRequest;

    /**
     * Get original request object
     * @return <code>null</code> if original request undefined in
     * request object
     */
    public OriginalRequest getOriginalRequest() {
      return originalRequest;
    }
  }