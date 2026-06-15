package Service.Analista_Service.Service;



import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class AnalistaService {

    @Value("${claude.api.key}")
    private String apiKey;

    private final ObjectMapper mapper = new ObjectMapper();

    public String explicar(Long pagamentoId, Long decisaoId) {
        String prompt = String.format("""
            Uma solicitação de devolução Pix foi processada com sucesso.
            ID da decisão: %s.
            ID do pagamento: %s.
            Explique de forma clara e humanizada para o cliente
            que a solicitação foi analisada e o pagamento foi processado.
            """,
            decisaoId,
            pagamentoId
        );

        return chamarClaude(prompt);
    }

    private String chamarClaude(String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);
        headers.set("anthropic-version", "2023-06-01");
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = Map.of(
            "model", "claude-sonnet-4-6",
            "max_tokens", 1024,
            "messages", List.of(
                Map.of("role", "user", "content", prompt)
            )
        );

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
            "https://api.anthropic.com/v1/messages",
            HttpMethod.POST,
            request,
            String.class
        );

        return extrairTexto(response.getBody());
    }

    private String extrairTexto(String responseBody) {
        try {
            JsonNode root = mapper.readTree(responseBody);
            return root.path("content").get(0).path("text").asText();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao extrair texto do Claude", e);
        }
    }
}
