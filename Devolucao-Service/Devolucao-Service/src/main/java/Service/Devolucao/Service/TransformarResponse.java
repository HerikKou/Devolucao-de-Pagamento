package Service.Devolucao.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import Service.Devolucao.DTO.DevolucaoResponseDTO;
import Service.Devolucao.Model.Devolucao;
import Service.Devolucao.Model.Status;
import Service.Devolucao.Repository.DevolucaoRepository;

@Component
public class TransformarResponse {
    private final DevolucaoRepository repository ;
    

    public TransformarResponse(DevolucaoRepository repository) {
        this.repository = repository;
    }


    public DevolucaoResponseDTO transformarResponse(Devolucao devolucao){
        int disputaAberta = quantidadeDeDisputaAberta(devolucao);
        int disputaRealizada = quantidadeDeDisputaRealizada(devolucao);
        int frequencia = frquencia(devolucao);
        DevolucaoResponseDTO response = new DevolucaoResponseDTO();
        response.setId(devolucao.getId());
        response.setTransacaoid(devolucao.getTransacaoid());
        response.setMotivo(devolucao.getMotivo());
        response.setQntdDisputaAberta(disputaAberta + 1);
        response.setQntdDeDisputaRealizada( disputaRealizada +1);
        response.setFrequencia(frequencia);
        response.setDataAbertura(devolucao.getDataAbertura().now());
        response.setStatus(Status.ABERTA);
        return response;


    }



    private int quantidadeDeDisputaAberta(Devolucao devolucao){
        return repository.countByIdTransacaoAndStatus(devolucao.getTransacaoid(), Status.ABERTA);
    }

    private int quantidadeDeDisputaRealizada(Devolucao devolucao){
         return repository.countByIdTransacaoAndStatus(devolucao.getTransacaoid(), Status.APROVADA);
    }

    private  int frquencia(Devolucao devolucao){
        return repository.countByIdTransacaoAndDataHora(devolucao.getTransacaoid(),LocalDateTime.now().minusHours(24), LocalDateTime.now());
    }
}
