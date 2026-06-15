package Service.Tansacao_Service.Service;

import org.springframework.stereotype.Component;

import Service.Tansacao_Service.DTO.TransacaoRequest;
import Service.Tansacao_Service.Model.Transacao;

@Component
public class TransformarEmEntidade {


    public Transacao Transformarentidade(TransacaoRequest request){
        Transacao transacao = new Transacao();
        transacao.setContaOrigem(request.getContaOrigem());
        transacao.setContaDestino(request.getContaDestino());
        transacao.setValor(request.getValor());
        transacao.setTipo(request.getTipo());
        return transacao;
        
    }
}
