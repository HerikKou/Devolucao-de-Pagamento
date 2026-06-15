package Service.Devolucao.Service;

import org.springframework.stereotype.Service;

import Service.Devolucao.DTO.DevolucaoEvento;
import Service.Devolucao.DTO.DevolucaoRequestDTO;
import Service.Devolucao.DTO.DevolucaoResponseDTO;
import Service.Devolucao.Model.Devolucao;
import Service.Devolucao.Repository.DevolucaoRepository;

@Service
public class ServicePrincipal {


    private final DevolucaoRepository repository;
    private final ProducerService producer;
   private final TransformarEntidade transformarEntidade;
   private final TransformarResponse response;
   public ServicePrincipal(DevolucaoRepository repository, ProducerService producer, TransformarEntidade transformarEntidade,
        TransformarResponse response) {
    this.repository = repository;
    this.producer = producer;
    this.transformarEntidade = transformarEntidade;
    this.response = response;
   }

   public DevolucaoResponseDTO criarDevolucao(DevolucaoRequestDTO request){

        Devolucao devolucao = transformarEntidade.entidade(request);
        Devolucao salvar = repository.save(devolucao);
        producer.enviarEvento(new DevolucaoEvento(salvar.getId(), salvar.getTransacaoid(), salvar.getQntdDisputaAberta(),salvar.getQntdDeDisputaRealizada(), salvar.getFrequencia()));

        return  response.transformarResponse(salvar);
   }
    
    
}
