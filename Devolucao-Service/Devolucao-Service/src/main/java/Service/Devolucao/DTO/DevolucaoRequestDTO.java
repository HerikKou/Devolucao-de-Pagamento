package Service.Devolucao.DTO;

import jakarta.validation.constraints.NotNull;

public class DevolucaoRequestDTO {
@NotNull
    private String motivo;

    public DevolucaoRequestDTO(){}

    public DevolucaoRequestDTO(String motivo) {
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    
}
