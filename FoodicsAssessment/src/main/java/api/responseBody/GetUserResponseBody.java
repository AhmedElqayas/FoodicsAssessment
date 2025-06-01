package api.responseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetUserResponseBody {
    public Data data;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        public int id;
        public String first_name;
        public String last_name;
        public String job;
    }
}
