package gov.tech.cdit.views;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@Value
public class ValidSalaryResponse {

    @JsonProperty("results")
    List<UserView> userViews;

}
