package quakereport.model.remote;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://kshemin.co.in:3000/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}