package Service.Devolucao.Service;

import org.springframework.stereotype.Component;

import Service.Devolucao.DTO.DevolucaoRequestDTO;
import Service.Devolucao.Model.Devolucao;

@Component
public class TransformarEntidade {

    public Devolucao entidade(DevolucaoRequestDTO request){
        Devolucao devolucao = new Devolucao();
        devolucao.setMotivo(request.getMotivo());
        return devolucao;
    }
}
