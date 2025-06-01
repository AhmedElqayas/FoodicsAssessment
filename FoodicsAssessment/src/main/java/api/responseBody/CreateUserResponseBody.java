package api.responseBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserResponseBody {
    public String first_name;
    public String last_name;
    public String job;
    public int id;
}
