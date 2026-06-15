package Service.Tansacao_Service.Service;

import org.springframework.stereotype.Component;

import Service.Tansacao_Service.DTO.TransacaoResponse;
import Service.Tansacao_Service.Model.Transacao;

@Component
public class TransformarEmResponse {

    public TransacaoResponse response(Transacao transacao){
        TransacaoResponse response = new TransacaoResponse();
        response.setId(transacao.getId());
        response.setContaOrigem(transacao.getContaOrigem());
        response.setContaDestino(transacao.getContaDestino());
        response.setValor(transacao.getValor());
        response.setTipo(transacao.getTipo());
        response.setDataHora(transacao.getDataHora().now());
        response.setStatus(transacao.getStatus().REALIZADA);
        return response;
        
    }
}
