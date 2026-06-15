package Service.Tansacao_Service.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.Tansacao_Service.DTO.TransacaoRequest;
import Service.Tansacao_Service.DTO.TransacaoResponse;
import Service.Tansacao_Service.Service.ServicePrincipal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("transacao/")
@RestController
public class ControllerTransacao {
    private final ServicePrincipal service;
    public ControllerTransacao(ServicePrincipal service) {
        this.service = service;
    }

    @PostMapping("/realizarTransacao")
    public ResponseEntity<TransacaoResponse> realizarTransferencia(@RequestBody TransacaoRequest request) {
        
        TransacaoResponse response = service.realizarTransacao(request);
        return ResponseEntity.status(201).body(response);
    }
    
}
