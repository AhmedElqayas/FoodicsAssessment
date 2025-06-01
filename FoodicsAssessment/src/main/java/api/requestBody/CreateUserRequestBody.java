package api.requestBody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUserRequestBody {
    public String first_name;
    public String last_name;
    public String job;
}
