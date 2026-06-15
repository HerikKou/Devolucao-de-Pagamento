package Service.Tansacao_Service.Service;

import org.springframework.stereotype.Service;

import Service.Tansacao_Service.DTO.TransacaoEvento;
import Service.Tansacao_Service.DTO.TransacaoRequest;
import Service.Tansacao_Service.DTO.TransacaoResponse;
import Service.Tansacao_Service.Model.Transacao;
import Service.Tansacao_Service.Repository.TransacaoRepository;

import org.slf4j.*;
@Service
public class ServicePrincipal {

    private ProducerService producer;
    private TransformarEmEntidade entidade;
    private TransformarEmResponse transformarEmResponse;
    private  final Logger log = LoggerFactory.getLogger(ServicePrincipal.class);
    private TransacaoRepository repository;
    public ServicePrincipal(ProducerService producer, TransformarEmEntidade entidade,
            TransformarEmResponse transformarEmResponse, TransacaoRepository repository) {
        this.producer = producer;
        this.entidade = entidade;
        this.transformarEmResponse = transformarEmResponse;
        this.repository = repository;
    }
   public TransacaoResponse realizarTransacao(TransacaoRequest request){
        Transacao transacao  = entidade.Transformarentidade(request);
        Transacao salvarTransacao = repository.save(transacao);
        TransacaoEvento evento = transformaremEvento(salvarTransacao);
         producer.enviarEventoDevolucao(evento);
         producer.enviarEventoDecisao(evento);
         return transformarEmResponse.response(transacao);
   }

   private TransacaoEvento transformaremEvento(Transacao transacao){
        return new TransacaoEvento(transacao.getId());
   }
}
