package me.teakivy.teakstweaks.utils.log;

import me.teakivy.teakstweaks.utils.config.Config;
import okhttp3.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class PasteBookUploader {

    private static final String TT_API_URL = "https://api.paste.teakstweaks.com/upload";
    private static final String TT_RESPONSE_URL = "https://paste.teakstweaks.com/p";
    private static final String PASTEBOOK_API_URL = "https://api.pastebook.dev/upload";
    private static final String PASTEBOOK_RESPONSE_URL = "https://pastebook.dev/p/";
    private static final MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain");

    private static final OkHttpClient client = new OkHttpClient();
    private static final long EXPIRES = 30 * 24 * 60 * 60 * 1000L; // 30 days
    private static final long DEV_EXPIRES = 20 * 60 * 1000L; // 20 minutes

    /**
     * Uploads the provided text to PasteBook and returns the result URL.
     *
     * @param text  The content to be uploaded
     * @param title The title of the post
     * @return The URL of the uploaded content
     * @throws IOException If an error occurs during the request
     */
    public static String uploadText(String text, String title) throws IOException {
        // Create request body with the provided text
        RequestBody body = RequestBody.create(text, MEDIA_TYPE_TEXT);

        Service service = getService();

        // Build the request
        Request request = new Request.Builder()
                .url(service.getApiUrl())
                .post(body)
                .addHeader("Content-Type", "text/plain")
                .addHeader("title", title)
                .addHeader("unlisted", "true")
//                .addHeader("expires", "2592000000")
                .addHeader("expires", Config.isDevMode() ? String.valueOf(DEV_EXPIRES) : String.valueOf(EXPIRES))
                .build();

        // Execute the request and get the response
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                // Return the URL if the response is successful
                return service.getResponseUrl() + response.body().string();
            } else {
                throw new IOException("Request failed with status code: " + response.code());
            }
        }
    }

    private static Service getService() {
        try {
            URL url = new URL("https://paste.teakstweaks.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(5000); // 5 seconds timeout
            connection.setReadTimeout(5000);
            int responseCode = connection.getResponseCode();
            if (200 <= responseCode && responseCode <= 399) {
                return Service.TEAKSTWEAKS;
            }
            return Service.PASTEBOOK;
        } catch (IOException e) {
            return Service.PASTEBOOK;
        }
    }

    private enum Service {
        TEAKSTWEAKS(TT_API_URL, TT_RESPONSE_URL),
        PASTEBOOK(PASTEBOOK_API_URL, PASTEBOOK_RESPONSE_URL);

        private final String API_URL;
        private final String RESPONSE_URL;

        Service(String API_URL, String RESPONSE_URL) {
            this.API_URL = API_URL;
            this.RESPONSE_URL = RESPONSE_URL;
        }

        public String getApiUrl() {
            return API_URL;
        }

        public String getResponseUrl() {
            return RESPONSE_URL;
        }
    }
}
