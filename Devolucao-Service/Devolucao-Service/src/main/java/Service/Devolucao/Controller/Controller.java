package Service.Devolucao.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Service.Devolucao.DTO.DevolucaoRequestDTO;
import Service.Devolucao.DTO.DevolucaoResponseDTO;
import Service.Devolucao.Service.ServicePrincipal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("transacao/")
@RestController
public class Controller {

    private final ServicePrincipal service;

    public Controller(ServicePrincipal service) {
        this.service = service;
    }
    
    @PostMapping("{transacaoId}/devolucao")
    public ResponseEntity<DevolucaoResponseDTO> postMethodName(@RequestBody DevolucaoRequestDTO request ,@PathVariable Long transacaoId) {

        DevolucaoResponseDTO response = service.criarDevolucao(request);

        return ResponseEntity.status(201).body(response);
    }
    
    
}
