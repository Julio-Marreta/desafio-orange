package com.example.desafioorange.veiculo;

import com.example.desafioorange.exceptions.AnoDoVeiculoNotFoundException;
import com.example.desafioorange.exceptions.MarcaNotFoundException;
import com.example.desafioorange.exceptions.ModeloNotFoundException;
import com.example.desafioorange.usuario.Usuario;
import com.example.desafioorange.veiculo.integracao.DetalheVeiculo;
import com.example.desafioorange.veiculo.integracao.FipeFeign;
import com.example.desafioorange.veiculo.integracao.Marca;
import com.example.desafioorange.veiculo.integracao.Modelos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormatSymbols;
import java.util.Calendar;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private FipeFeign fipeFeign;

    public Veiculo save(Veiculo veiculo, Long id) throws MarcaNotFoundException, ModeloNotFoundException, AnoDoVeiculoNotFoundException {
        Marca marcaFipe = fipeFeign.getMarcas()
                .stream()
                .filter(bf -> bf.getNome().equalsIgnoreCase(veiculo.getMarca()))
                .findFirst()
                .orElseThrow(MarcaNotFoundException::new);

        String idMarca = marcaFipe.getCodigo();

        Modelos.Modelo modelo = fipeFeign.getModelos(idMarca).getModelos()
                .stream()
                .filter(m -> m.getNome().equalsIgnoreCase(veiculo.getModelo()))
                .findFirst()
                .orElseThrow(ModeloNotFoundException::new);

        Integer idModelo = modelo.getCodigo();

        com.example.desafioorange.veiculo.integracao.Veiculo anoVeiculo = fipeFeign.getAnos(idMarca, idModelo)
                .stream()
                .filter(v -> v.getCodigo().equals(veiculo.getAno()))
                .findFirst()
                .orElseThrow(AnoDoVeiculoNotFoundException::new);

        String ano = anoVeiculo.getCodigo();

        DetalheVeiculo vehicleDetails = fipeFeign.getDetalhes(idMarca, idModelo, ano);

        veiculo.setValor(vehicleDetails.getValor());
        setRotacaoVeiculo(veiculo);

        Usuario usuario = new Usuario();
        usuario.setId(id);

        veiculo.setUsuario(usuario);
        return veiculoRepository.save(veiculo);
    }

    private void setRotacaoVeiculo(Veiculo veiculo) {
        String diaSemana = "";
        String ultimoDigitoAno = veiculo.getAno().substring(veiculo.getAno().length() - 1);

        switch (ultimoDigitoAno) {
            case "0" :
            case "1":
                diaSemana = "segunda-feira";
                break;

            case "2" :
            case "3" :
                diaSemana = "terça-feira";
                break;

            case "4" :
            case "5" :
                diaSemana = "quarta-feira";
                break;

            case "6" :
            case "7" :
                diaSemana = "quinta-feira";
                break;

            case "8" :
            case "9" :
                diaSemana = "sexta-feira";
                break;
        }

        veiculo.setDiaRotacao(diaSemana);

        if(diaSemana.equals(getDiaSemana())){
            veiculo.setRotacaoAtiva(true);
        }
    }

    public static String getDiaSemana(){
        return new DateFormatSymbols().getWeekdays()[Calendar.getInstance().get(Calendar.DAY_OF_WEEK)];
    }
}
