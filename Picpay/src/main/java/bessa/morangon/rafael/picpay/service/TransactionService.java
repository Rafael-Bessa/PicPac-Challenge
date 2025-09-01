package bessa.morangon.rafael.picpay.service;

import bessa.morangon.rafael.picpay.model.AuthorizationResponse;
import bessa.morangon.rafael.picpay.model.Type;
import bessa.morangon.rafael.picpay.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private final RestTemplate restTemplate;
    private static final String URL = "https://util.devi.tools/api/v2/authorize";

    //  Preciso deste final, então só consigo injetar pelo construtor
    //  Ferramenta que faz requisições HTTP (GET, POST) para outros serviços.

    public TransactionService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public boolean isAuthorized() {
        try {
            AuthorizationResponse response = restTemplate.getForObject(
                    "https://util.devi.tools/api/v2/authorize",
                    AuthorizationResponse.class
            );

            return response != null
                    && response.getData() != null
                    && Boolean.TRUE.equals(response.getData().getAuthorization());

        } catch (Exception e) {
            throw new RuntimeException("Serviço de autorização indisponível");
        }
    }

}
