package bessa.morangon.rafael.picpay.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthorizationResponse {

    private String status;
    @JsonProperty("data")
    private AuthorizationData data; // campo data do JSON

    // Classe interna que representa o objeto "data" do JSON
    @Data
    public static class AuthorizationData {
        private Boolean authorization;

    }
}
