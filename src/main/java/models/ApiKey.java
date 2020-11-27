package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiKey {
    @JsonProperty
    private String key;

    @JsonProperty
    private String name;
}